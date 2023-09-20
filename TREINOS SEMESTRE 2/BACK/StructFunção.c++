#include <iostream>
#include <string.h>
#include <stdio.h>

using namespace std;

// Construir um programa que define uma struct produto com os campos: código
// (int), nome (string), quantidade em estoque (int) , preco(float). Faz a leitura de N
// produtos e os armazena em um arranjo. Adiciona à quantidade em estoque uma
// nova quantidade de um determinado produto comprado pela empresa. Por
// exemplo: suponha que a quantidade em estoque do produto “cadeira” seja 15 e o
// dono da empresa compra mais 20 cadeiras. Seu programa deve acrescentar esta
// nova quantidade: 20, à quantidade em estoque anterior: 15. Assim, a quantidade
// atual do produto será 35. Para buscar um determinado produto para a atualização
// do estoque, usar como entrada o código do produto. Dividir o programa em
// módulos.
// a. Função 1:faz a leitura do N e das informações de N produtos, armazenandoos num vetor.
// b. Função 2: recebe os dados de N produtos, faz a leitura de um código e a
// quantidade comprada, busca o produto na tabela e adiciona a quantidade
// comprada à quantidade em estoque.
// c. Função 3: imprime as informações de N produtos.
// d. Main: define as variáveis do problema e chama as funções. Definir o
// tamanho físico para 100 elementos

struct produto{
    int codigo;
    char nome[20];
    int qnt;
    float preco;
};

void ler_vetor( int *n, produto vet[]){

    int i;

    cout << "Digite a quantidade de produtos: ";
    cin >> *n;
    
    for(i=0;i<*n;i++){
        cin >> vet[i].codigo;
        cin.ignore();
        cin.getline(vet[i].nome,20);
        cin >> vet[i].qnt;
        cin >> vet[i].preco;
    }
}

void atualiza_estoque(int n, produto vet[]){
    int codigo,i,qntc;

    cout << "\nDigite o codigo do produto para realizar a busca: ";
    cin >> codigo;
    for(i=0;i<n;i++){
        if(codigo = vet[i].codigo){
            cout <<  vet[i].codigo;
            cout << "Digite a quantidade de " << vet[i].nome << " compradxs";
            cin >> qntc;
            vet[i].qnt += qntc;
            break;
        }
    }
}

void imprime_produtos(int n, produto vet[]){
    int i;
    for(i=0;i<n;i++){
        cout << "\nInformações do seu produto: ";
        cout << vet[i].codigo << endl;
        cout << vet[i].nome << endl;
        cout << vet[i].qnt << endl;
        cout << vet[i].preco << endl;
    }
}


int main() {

    int n;
    produto vet[100];

    ler_vetor(&n,vet);
    atualiza_estoque(n,vet);
    imprime_produtos(n,vet);

    return 0;
}
