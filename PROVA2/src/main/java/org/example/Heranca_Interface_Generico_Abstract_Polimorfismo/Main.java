package org.example.Heranca_Interface_Generico_Abstract_Polimorfismo;

public class Main {
    public static void main(String[] args) {
        try {
            // Testes para a classe Caixa
            Caixa<String> c1 = new Caixa<>("String");
            Caixa<String> c2 = new Caixa<>("String");

            System.out.println("Caixa<String> c1 equals c2: " + c1.equals(c2));
            System.out.println("Caixa<String> c1 hashCode: " + c1.hashCode());
            System.out.println("Caixa<String> c2 hashCode: " + c2.hashCode());

            Caixa<String> c5 = (Caixa<String>) c1.clone();
            System.out.println("Caixa<String> c1 equals c5 (clone): " + c1.equals(c5));

            // Testes para a classe Caixa com Data
            Data data1 = new Data((byte) 1, (byte) 1, (short) 2020);
            Data data2 = new Data((byte) 1, (byte) 1, (short) 2020);

            Caixa<Data> caixaData1 = new Caixa<>(data1);
            Caixa<Data> caixaData2 = new Caixa<>(data2);

            System.out.println("Caixa<Data> caixaData1 equals caixaData2: " + caixaData1.equals(caixaData2));
            System.out.println("Caixa<Data> caixaData1 hashCode: " + caixaData1.hashCode());
            System.out.println("Caixa<Data> caixaData2 hashCode: " + caixaData2.hashCode());

            Caixa<Data> caixaData3 = (Caixa<Data>) caixaData1.clone();
            System.out.println("Caixa<Data> caixaData1 equals caixaData3 (clone): " + caixaData1.equals(caixaData3));

            // Testes para a classe Conjunto
            Conjunto<String> conjunto1 = new Conjunto<>();
            conjunto1.inclua("Elemento1");
            conjunto1.inclua("Elemento2");

            Conjunto<String> conjunto2 = new Conjunto<>();
            conjunto2.inclua("Elemento1");
            conjunto2.inclua("Elemento2");

            System.out.println("Conjunto<String> conjunto1 equals conjunto2: " + conjunto1.equals(conjunto2));
            System.out.println("Conjunto<String> conjunto1 hashCode: " + conjunto1.hashCode());
            System.out.println("Conjunto<String> conjunto2 hashCode: " + conjunto2.hashCode());

            Conjunto<String> conjunto3 = (Conjunto<String>) conjunto1.clone();
            System.out.println("Conjunto<String> conjunto1 equals conjunto3 (clone): " + conjunto1.equals(conjunto3));

            // Testes para a classe Conjunto com Data
            Conjunto<Data> conjuntoData1 = new Conjunto<>();
            conjuntoData1.inclua(new Data((byte) 1, (byte) 1, (short) 2020));
            conjuntoData1.inclua(new Data((byte) 2, (byte) 2, (short) 2021));

            Conjunto<Data> conjuntoData2 = new Conjunto<>();
            conjuntoData2.inclua(new Data((byte) 1, (byte) 1, (short) 2020));
            conjuntoData2.inclua(new Data((byte) 2, (byte) 2, (short) 2021));

            System.out.println("Conjunto<Data> conjuntoData1 equals conjuntoData2: " + conjuntoData1.equals(conjuntoData2));
            System.out.println("Conjunto<Data> conjuntoData1 hashCode: " + conjuntoData1.hashCode());
            System.out.println("Conjunto<Data> conjuntoData2 hashCode: " + conjuntoData2.hashCode());

            Conjunto<Data> conjuntoData3 = (Conjunto<Data>) conjuntoData1.clone();
            System.out.println("Conjunto<Data> conjuntoData1 equals conjuntoData3 (clone): " + conjuntoData1.equals(conjuntoData3));

            // Testes de Heranca
            //Heranca de classes comuns, pode ser do tipo da Superclasse e instanciar a Subclasse
            String nome = "Rex";
            Animal meuAnimal = new Animal(nome);
            Animal meuCachorro = new Cachorro(nome);

            meuAnimal.fazerSom();
            meuCachorro.fazerSom();

            // Testes de Interface
            //Instanciamos tipo Veiculo mas instancia da classe Carro
            Veiculo meuCarro = new Carro();

            meuCarro.acelerar();
            meuCarro.frear();

            //Teste de Heranca Abstract
            //Metodo atacar() eh abstrato e nao foi implementado na classe Animal2, mas veio da classe Cachorro2 (Superclasse)
            //Instanciamos tipo Animal2 mas instancia da classe Cachorro2
            Animal2 meuCachorro3 = new Cachorro2();

            meuCachorro3.fazerSom();
            meuCachorro3.atacar();

            // Teste de polimorfismo
            //O polimorfismo ocorre quando você usa uma referência do tipo da superclasse para armazenar uma instância de uma subclasse.
            //Heranca comum
            Animal meuCachorro2 = new Cachorro(nome);
            meuCachorro2.fazerSom();
            //Interface
            Veiculo meuCarro2 = new Carro();
            meuCarro2.acelerar();
            meuCarro2.frear();
            //Heranca Abstract
            Animal2 meuCachorro4 = new Cachorro2();
            meuCachorro4.fazerSom();
            meuCachorro4.atacar();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}