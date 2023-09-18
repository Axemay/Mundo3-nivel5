/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroserver;

import cadastroserver.controller.MovimentacaoJpaController;
import cadastroserver.controller.PessoaJpaController;
import cadastroserver.controller.ProdutoJpaController;
import cadastroserver.controller.UsuarioJpaController;
import cadastroserver.model.Movimentacao;
import cadastroserver.model.Pessoa;
import cadastroserver.model.Produto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Maiara
 */
public class CadastroThread extends Thread {

    private final ProdutoJpaController ctrl;
    private final UsuarioJpaController ctrlUsuario;
    private final Socket s1;
    private final PessoaJpaController ctrlPessoa;
    private final MovimentacaoJpaController ctrlMovimento;

    private boolean isRunning = true;

    public CadastroThread(ProdutoJpaController ctrl, UsuarioJpaController ctrlUsuario, Socket s1, PessoaJpaController ctrlPessoa, MovimentacaoJpaController ctrlMovimento) {
        this.ctrl = ctrl;
        this.ctrlUsuario = ctrlUsuario;
        this.s1 = s1;
        this.ctrlPessoa = ctrlPessoa;
        this.ctrlMovimento = ctrlMovimento;

    }

    public void run() {
        try (
                BufferedReader entrada = new BufferedReader(new InputStreamReader(s1.getInputStream())); PrintWriter saida = new PrintWriter(s1.getOutputStream(), true)) {

            String login = entrada.readLine();
            String senha = entrada.readLine();

            if (validateCredentials(login, senha)) {
                saida.println("Autenticação realizada com sucesso!");

                while (isRunning) {
                    String command = entrada.readLine();
                    if (command != null) {
                        if (command.equals("L")) {

                            sendProductList(saida);
                        } else if (command.equals("E") || command.equals("S")) {

                            processMovement(command, entrada, saida);
                        } else if (command.equals("X")) {

                            break;
                        }
                    }
                }
            } else {
                saida.println("Credenciais inválidas. Conexão encerrada.");
                s1.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(CadastroThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Encerre a conexão e a thread
            try {
                s1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean validateCredentials(String login, String senha) {

        return true;
    }

    private void sendProductList(PrintWriter out) {
        List<Produto> productList = ctrl.findProdutoEntities();
        out.println("Lista de produtos:");

        for (Produto product : productList) {
            out.println(product.getNome());
        }
        out.println();
    }

    private void processMovement(String type, BufferedReader in, PrintWriter out) throws IOException, Exception {
        try {
            String personIdStr = in.readLine();
            String productIdStr = in.readLine();
            String quantityStr = in.readLine();
            String unitPriceStr = in.readLine();

            int personId = Integer.parseInt(personIdStr);
            int productId = Integer.parseInt(productIdStr);
            int quantity = Integer.parseInt(quantityStr);
            double unitPrice = Double.parseDouble(unitPriceStr);

            Pessoa person = ctrlPessoa.findPessoa(personId);
            Produto produto = ctrl.findProduto(productId);

            if (person != null && produto != null) {
               
                if (type.equals("S") && produto.getQuantidadeEstoque() < quantity) {
                    out.println("Quantidade insuficiente para saída. Operação cancelada.");
                } else {
                   
                    Movimentacao movement = new Movimentacao();
                    movement.setIdPessoa(person);
                    movement.setIdProduto(produto);
                    movement.setQuantidade(quantity);
                    movement.setValorUnitario(unitPrice);
                    movement.setTipo(type);

                    
                    ctrlMovimento.create(movement);

                    // Atualizar a quantidade do produto de acordo com o tipo de movimento
                    if (type.equals("E")) {
                        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + quantity);
                    } else if (type.equals("S")) {
                        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantity);
                    }
                    ctrl.edit(produto);

                    out.println("Operação concluída com sucesso.");
                }
            } else {
                out.println("Pessoa ou produto não encontrados. Operação cancelada.");
            }
        } catch (NumberFormatException e) {
            out.println("Entrada inválida. Operação cancelada.");
        }
    }

    // Método para encerrar a thread de maneira adequada
    public void stopThread() {
        isRunning = false;
    }
}
