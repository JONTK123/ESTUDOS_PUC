package prova1;
import prova1.model.Data;
import prova1.model.Aluno;

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
        Aluno a1 = new Aluno ("Joao", "23010116", "22", "25/07/2002");
        System.out.println(h1);
    }
}