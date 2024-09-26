package prova1;

import prova1.model.Aluno;
import prova1.model.Data;
import prova1.model.Teclado;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

    //Esse é o método que a JVM (Java Virtual Machine) chama para iniciar a execução do programa.
    //Static - porque o método main é chamado pela JVM e não requer uma instância de classe
    //Public - porque a JVM precisa ter acesso a esse método
    //String[] args - é usado para obter argumentos da linha de comando
    public static void main(String[] args) {

        //Isto eh uma instancia/objeto da classe Aluno
        //a1 - ponteiro para endereco (local) de memoria do objeto onde foi armazenado
        //Para chamar um metodo, usar nome instancia + ponto + nome do metodo
        //This eh implicito e funciona como uma passagem de parametro p o metodo
        Aluno a1 = new Aluno ("Joao", "23010116", "22", "25/07/2002");
        Aluno a2 = new Aluno ("Maria", "23010117", "22", "25/07/2002");
        System.out.println(h1);

        String nomeAluno = ai.getNome();
        System.out.println(nomeAluno);

        //Testando o throws exception do metodo getNome()
        try {
            String nomeAluno2 = a2.getNome();
            System.out.println(nomeAluno2);
        } catch (Exception e) {
            System.out.println("Erro ao obter nome do aluno");
        }

        a1.setNome("Joao");
        System.out.println(a1.getNome());

        //Utilizando método toString()
        System.out.println(a1.toString());

        //Utilizando método equals()
        Aluno a2 = new Aluno ("Joao", "23010115", "22", "25/07/2002");
        System.out.println(a1.equals(a2));

        //exemplo clone
        Aluno a3 = a1.clone();
        a3.setNome("Maria"); //Alternado nome de a3 ( igual a1 ) sem alterar ponteiro de a1
        System.out.println(a3);

        //exemplo metodo do extends
        a1.mostrarNome();

        //exemplo atributo do extends ( a1 e a2 vao dar erro pois precisam de cpf agora dps de dar extends
        System.out.println(a1.CPF);

        //exemplo metodo compareTo
        System.out.println(a1.compareTo(a2));

    }
}