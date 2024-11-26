package org.example.Sockets;

import java.net.*;
import java.io.*;

public class Proativo {
    public static void main(String[] args) {
        try {
            // Conecta ao servidor no endereço IP "172.16.1.183" na porta 10000
            Socket conexao = new Socket("172.16.1.183", 10000);

            // Cria um BufferedReader para ler dados de texto do servidor
            BufferedReader receptor = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            /*
            // Alternativa: Usar DataInputStream para tipos de dados primitivos
            DataInputStream receptor = new DataInputStream(conexao.getInputStream());
            // readInt e readFloat são alguns métodos

            // Alternativa: Usar ObjectInputStream para objetos
            ObjectInputStream receptor = new ObjectInputStream(conexao.getInputStream());
            // readObject é o método
            */

            // Cria um PrintWriter para enviar dados de texto ao servidor
            PrintWriter transmissor = new PrintWriter(conexao.getOutputStream());
            /*
            // Alternativa: Usar DataOutputStream para tipos de dados primitivos
            DataOutputStream transmissor = new DataOutputStream(conexao.getOutputStream());
            // writeInt e writeFloat são alguns métodos

            // Alternativa: Usar ObjectOutputStream para objetos
            ObjectOutputStream transmissor = new ObjectOutputStream(conexao.getOutputStream());
            // writeObject é o método
            */

            // Cria um BufferedReader para ler dados de texto do teclado
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            String texto;
            // Lê e envia mensagens ao servidor até que "FIM" seja digitado
            do {
                texto = teclado.readLine();
                transmissor.println(texto); // Envia mensagem
                transmissor.flush(); // Envio imediato
            } while (!texto.toUpperCase().equals("FIM"));

            // Fecha todos os recursos
            transmissor.close();
            receptor.close();
            conexao.close();
        } catch (Exception erro) {
            System.err.println(erro.getMessage());
        }
    }
}