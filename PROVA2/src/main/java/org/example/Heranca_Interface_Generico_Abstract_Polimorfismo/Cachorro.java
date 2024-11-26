package org.example.Heranca_Interface_Generico_Abstract_Polimorfismo;

//Subclasse
//Extends pq Classe com Classe
public class Cachorro extends Animal {

    //como temos um atributo e temos um construtor na superclasse, eh necessario usar o super() na subclasse
    public Cachorro(String nome){
        super(nome);
    }

    @Override
    public void fazerSom() {
        System.out.println("Testando Heranca -> O cachorro late");
    }
}