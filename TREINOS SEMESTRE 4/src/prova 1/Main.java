package prova1;

import prova1.model.Aluno;
import prova1.model.Data;
import prova1.model.Teclado;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Vector;


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

        System.out.println("EXEMPLOS DE USO DE CLASSES E OBJETOS/INSTANCIAS");
        Aluno a1 = new Aluno ("Joao", "23010116", "22", "25/07/2002");
        Aluno a2 = new Aluno ("Maria", "23010117", "22", "25/07/2002");
        System.out.println(h1);

        //---------------------------------------------------------------------------------------------------
        //---------------------------------------------------------------------------------------------------

        System.out.println("EXEMPLO DE USO DE GET DO ALUNO1");
        String nomeAluno = ai.getNome();
        System.out.println(nomeAluno);

        //Testando o throws exception do metodo getNome()
        System.out.println("EXEMPLO DE USO DE GET DO ALUNO2");
        try {
            String nomeAluno2 = a2.getNome();
            System.out.println(nomeAluno2);
        } catch (Exception e) {
            System.out.println("Erro ao obter nome do aluno");
        }

        //---------------------------------------------------------------------------------------------------
        //---------------------------------------------------------------------------------------------------

        System.out.println("EXEMPLO DE USO DE SET DO ALUNO1");
        a1.setNome("Joao");
        System.out.println(a1.getNome());

        System.out.println("EXEMPLO DE USO DE TOSTRING DO ALUNO1");
        //Utilizando método toString()
        System.out.println(a1.toString());

        //---------------------------------------------------------------------------------------------------
        //---------------------------------------------------------------------------------------------------

        System.out.println("EXEMPLO UTILIZANDO METODO EQUALS");
        //Utilizando método equals()
        Aluno a2 = new Aluno ("Joao", "23010115", "22", "25/07/2002"); //Sempre passar o tipo do atributo para garantir q funcione
        //Aluno a2 = new Aluno ("Joao", "23010116", (byte) "22", "25/07/2002");
        System.out.println(a1.equals(a2));

        //---------------------------------------------------------------------------------------------------
        //---------------------------------------------------------------------------------------------------

        System.out.println("EXEMPLOS DE CLONE");
        //exemplo clone
        Aluno a3 = a1.clone();
        a3.setNome("Maria"); //Alternado nome de a3 ( igual a1 ) sem alterar ponteiro de a1
        System.out.println(a3);

        //---------------------------------------------------------------------------------------------------
        //---------------------------------------------------------------------------------------------------


        System.out.println("EXEMPLO USANDO METODO compareTo");
        //exemplo metodo compareTo
        System.out.println(a1.compareTo(a2));

        //---------------------------------------------------------------------------------------------------
        //---------------------------------------------------------------------------------------------------

        System.out.println("EXEMPLO USANDO METODO DA HERANCA (EXTENDS)");
        //exemplo metodo do extends
        a1.mostrarNome();


        System.out.println("EXEMPLO USANDO ATRIBUTO DA HERANCA (EXTENDS)");
        //exemplo atributo do extends ( a1 e a2 vao dar erro pois precisam de cpf agora dps de dar extends
        System.out.println(a1.CPF);

        //---------------------------------------------------------------------------------------------------
        //---------------------------------------------------------------------------------------------------

        //exemplo interface
        //Interface Usuario -> getLogin, setLoigin, getSenha, setSenha
        //Primeiro nos criamos um objeto usuario
        Usuario usuario = null

        //Depois atribuimos uma CLASSE para objeto usuario que representa uma interface
        //Eh aqui que saberemos que a classe Aluno (EXATAMENTE ESSA) esta implementando seus metodos junto com a interface usuario
        usuario = new Aluno("Joao", "23010116", "22", "25/07/2002");

        //Caso uma outra classe implemente a interface usuario
        //Eh aqui que saberemos que a classe X (EXATAMENTE ESSA) esta implementando seus metodos junto com a interface usuario
        //Ela tera uma outra forma de implementar os metodos da interface usuario
        //usuario = new X("Joao", "23010116", "22", "25/07/2002");

        //Agora sabendo que as duas classes possuem o metodo setLogin, ao executa-la
        //Nao saberemos se esta sendo executado o metodo da classe Aluno ou da classe X - POLIMORFISMO
        usuario.getLogin();

        //---------------------------------------------------------------------------------------------------
        //---------------------------------------------------------------------------------------------------

        //exemplo com classe abstract
        //Classe abstrata AlunoMetodos -> adicionarAluno, removerAluno
        //Primeiro a instancia de aluno
        Aluno a3 = new Aluno ("Kleber pica de mel", "23010116", "26", "25/07/2002");
        //Depois, chamamos o metodo da classe AlunoMetodos que foi sobreescrito na classe Aluno
        a3.adicionarAluno();


    }
}