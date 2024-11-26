package org.example.Heranca_Interface_Generico_Abstract_Polimorfismo;

// Classe que implementa a interface
// Implements Veiculo pois Classe com Veiculo
public class Carro implements Veiculo {

    // Implementação dos métodos da interface, aqui de fato implementamos o metodo
    @Override
    public void acelerar() {
        System.out.println("Teste de Interface -> O carro está acelerando");
    }

    // Implementação dos métodos da interface, aqui de fato implementamos o metodo
    @Override
    public void frear() {
        System.out.println("Teste de Interface -> O carro está freando");
    }
}