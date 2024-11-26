//Parte 1 - Classe Apartamento
//Suponha a existência de uma classe chamada Apartamento, que representa um apartamento de hotel com os seguintes atributos:
//
//numero (string),
//capacidade (int),
//comCamaDeCasal (boolean),
//ocupado (boolean),
//interditado (boolean).
//Tal classe supostamente exibiria as seguintes características públicas:
//        (a) Um construtor que recebe como parâmetros valores para todos os atributos do Apto, na ordem em que foram apresentados acima;
//(b) Getters para todos os atributos;
//(c) Setters para todos os atributos;
//(d) O método toString.
//
//        Parte 2 - Classe Hospedaria
//Suponha a existência de uma classe chamada Hospedaria, que representa uma hospedaria com os seguintes atributos:
//
//protected: apto (um vetor de objetos da classe Apartamento)
//qtd (int).
//Tal classe exibiria as seguintes características públicas:
//        (a) Um construtor público que, recebendo a quantidade de andares do hotel (até 99), inicia, apropriadamente, as estruturas internas da mesma, de forma que, de acordo com o primeiro andar rumo ao último, sejam desprezadas as frações:
//
//        30% com 10 apartamentos de casal como adicional,
//        25% com 20 apartamentos single,
//20% com 15 apartamentos duplos e os demais andares com apartamentos com casal e adicional;
//Os apartamentos do hotel devem ser numerados seguindo um número correspondente à concatenação do número do andar de 2 dígitos com um número sequencial de 2 dígitos.
//        (b) Getters e setters para os atributos protected e qtd;
//(c) Um método público chamado ocupa, que recebendo como parâmetro o número do apartamento, promove sua ocupação;
//(d) Um método público chamado desocupa, que recebendo como parâmetro o número do apartamento, promove sua desocupação.
//
//        Parte 3 - Classe Hotel (Herdada de Hospedaria)
//Pede-se que implemente uma classe chamada Hotel, derivada (que herda) da classe Hospedaria, que implementaria os seguintes métodos:
//        (a) Um construtor público com as mesmas características e funcionamento do construtor da classe Hospedaria (Posto que construtores não são herdados), que acionaria tal construtor, terceirizando para ele todo o trabalho necessário; [2,5 pontos]
//
//        (b) Um método público chamado interdita, que, recebendo como parâmetro o número de um apartamento, promove sua interdição; um método público chamado desinterdita, que, recebendo como parâmetro o número de um apartamento, promove sua desinterdição. [5,0 pontos, sendo 2,5 pontos para cada método pedido neste item]
//
//        (c) Um método público chamado capacidade, que, sem receber parâmetros, resulta na capacidade de hospedagem do hotel (desconsiderando-se apartamentos ocupados e interditados). [2,5 pontos]

package org.example.Exercicios;

public class Hotel extends Hospedaria {
    public hotel (int qtd) {
        //vetor de apto eh protected, logo eu nao tenho acesso
        if ( qtd > 0 && qtd < 100) { //validacao
            super(qtd);
        } else {
            throw new IllegalArgumentException("Quantidade de andares invalida");
        }
    }

    public void interdite(int numero) {
        if (numero < 0 ) {
            throw new IllegalArgumentException("Numero do apartamento invalido");
        }

        for (int i = 0; i < super.apto.length; i++ ) {
            if (super.apto[i].getNumero().equals( numero )) { //PRESTAR ATENCAO NOS ATRIBUTOS DA SUPERCLASSE ELE EH STRING
                super.apto[i].ocupe(numero);
            }
        }
    }

    public void desinterdite(int numero) {
        if (numero < 0 ) {
            throw new IllegalArgumentException("Numero do apartamento invalido");
        }

        for (int i=0; i< super.apto.length; i++ ) {
            if (super.apto[i].getNumero().equals(numero)) {
                super.apto[i].desocupe(numero);
            }
        }
    }

    public int capacidade() {
        int cont = 0;

        for (int i=0; i<super.apto.length; i++) {
            if (super.apto[i].getOcupado() == false && super.apto[i].getInterditato() == false) {
                cont++;
            }
        }
        return cont;
    }
}

//PRESTAR ATENCAO NOS ENUNCIADOS E EM TODOS OS METODOS E DETALHES Q ELE DISSER
//Se a classe nao tiver atributos, nao precisa de nenhu  metood obrigatorio



