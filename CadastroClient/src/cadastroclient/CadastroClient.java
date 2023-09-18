/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastroclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Maiara
 */
public class CadastroClient {


    public static void main(String[] args) {
        try (
                Socket socket = new Socket("localhost", 4321);
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Conectado ao servidor.");
            System.out.print("Digite seu login: ");
            String login = consoleIn.readLine();
            System.out.print("Digite sua senha: ");
            String senha = consoleIn.readLine();

            saida.println(login);
            saida.println(senha);

            String response = entrada.readLine();
            System.out.println(response);

            if (response.equals("Autenticação realizada com sucesso!")) {
                while (true) {
                    System.out.print("Digite 'L' para listar produtos ou 'S' para sair: ");
                    String command = consoleIn.readLine();
                    saida.println(command);

                    if (command.equalsIgnoreCase("S")) {
                        break;
                    }

                    if (command.equalsIgnoreCase("L")) {

                        receiveAndDisplayProductList(entrada);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void receiveAndDisplayProductList(BufferedReader in) throws IOException {
        System.out.println("Conjunto de produtos disponíveis:");
        String line;
        while ((line = in.readLine()) != null && !line.isEmpty()) {
            System.out.println(line);
        }
    }
}

