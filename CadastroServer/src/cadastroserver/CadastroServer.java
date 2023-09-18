/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastroserver;

import cadastroserver.controller.ProdutoJpaController;
import cadastroserver.controller.UsuarioJpaController;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Maiara
 */
public class CadastroServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CadastroServerFactory");
        
        ProdutoJpaController ctrl = new ProdutoJpaController(entityManagerFactory);
        UsuarioJpaController ctrlUsu = new UsuarioJpaController(entityManagerFactory);
        ServerSocket serverSocket = new ServerSocket(4321);
        
        while (true) {
                System.out.println("Buscando conexão");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado.");

                
                ClientHandler clientHandler = new ClientHandler(clientSocket, ctrl, ctrlUsu);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
    }
    
}
