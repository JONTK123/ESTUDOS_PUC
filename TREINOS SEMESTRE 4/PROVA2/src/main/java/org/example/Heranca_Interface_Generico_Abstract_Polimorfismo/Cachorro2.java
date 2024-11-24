package org.example.Heranca_Interface_Generico_Abstract_Polimorfismo;

//Subclasse
//Extends pq Classe com Classe
public class Cachorro2 extends Animal2 {

    @Override
    public void atacar() {
        System.out.println("Testando Heranca Abstract cachorro morde");
    }

    //Metodo fazer Som ja esta implementado na classe abstrata
}