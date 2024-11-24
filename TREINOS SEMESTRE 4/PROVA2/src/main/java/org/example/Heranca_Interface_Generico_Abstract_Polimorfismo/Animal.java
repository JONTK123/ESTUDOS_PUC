package org.example.Heranca_Interface_Generico_Abstract_Polimorfismo;

// Superclasse
public class Animal {
    private String nome;

    //como temos um atributo e temos um construtor na superclasse, eh necessario usar o super() na subclasse
    public Animal(String nome){
        this.nome = nome;
    }

    public void fazerSom() {
        System.out.println("Testando Heranca -> O animal faz um som");
    }
}