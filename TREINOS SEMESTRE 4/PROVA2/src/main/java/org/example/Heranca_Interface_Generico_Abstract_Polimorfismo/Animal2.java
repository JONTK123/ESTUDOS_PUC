package org.example.Heranca_Interface_Generico_Abstract_Polimorfismo;

//Classe Abstrata funciona como se fosse uma interface, mas com implementação de métodos ( se quiser )
//Abstract - Significa que a classe nao pode ser instanciada, metodos abstratos devem ser implementados nas subclasses e classe abstrata pode ter metodos implementados
//Protected - Atributos e metodos protegidos podem ser acessados pelas subclasses
public abstract class Animal2 {

    protected abstract void atacar();

    public void fazerSom() {
        System.out.println("Testando Heranca Abstract -> O animal faz um som");
    }
}