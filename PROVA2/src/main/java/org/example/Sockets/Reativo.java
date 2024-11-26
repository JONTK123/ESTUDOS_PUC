package org.example.Sockets;

import java.net.*;
import java.io.*;

public class Reativo {
    public static void main(String[] args) {
        try {
            // Cria um socket de servidor escutando na porta 10000
            ServerSocket pedido = new ServerSocket(10000);
            // Aceita uma conexão de entrada
            Socket conexao = pedido.accept();

            // Cria um BufferedReader para ler dados de texto do cliente
            BufferedReader receptor = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            /*
            // Alternativa: Usar DataInputStream para tipos de dados primitivos
            DataInputStream receptor = new DataInputStream(conexao.getInputStream());
            // readInt e readFloat são alguns métodos

            // Alternativa: Usar ObjectInputStream para objetos
            ObjectInputStream receptor = new ObjectInputStream(conexao.getInputStream());
            // readObject é o método
            */

            // Cria um PrintWriter para enviar dados de texto ao cliente
            PrintWriter transmissor = new PrintWriter(conexao.getOutputStream());
            /*
            // Alternativa: Usar DataOutputStream para tipos de dados primitivos
            DataOutputStream transmissor = new DataOutputStream(conexao.getOutputStream());
            // writeInt e writeFloat são alguns métodos

            // Alternativa: Usar ObjectOutputStream para objetos
            ObjectOutputStream transmissor = new ObjectOutputStream(conexao.getOutputStream());
            // writeObject é o método
            */

            String texto;
            // Lê e imprime mensagens do cliente até receber "FIM"
            do {
                texto = receptor.readLine();
                System.out.println(texto);
            } while (!texto.toUpperCase().equals("FIM"));

            // Fecha todos os recursos
            transmissor.close();
            receptor.close();
            conexao.close();
            pedido.close();
        } catch (Exception erro) {
            System.err.println(erro.getMessage());
        }
    }
}