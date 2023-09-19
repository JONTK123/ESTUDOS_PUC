#include <stdio.h>
#include <iostream>
#include <string.h>

using namespace std;

// Construir um programa que faz a leitura de informações de N clientes de uma empresa (cpf: string, nome:
// string, endereço: struct, número_filhos: int) e imprime apenas os clientes que são de uma determinada cidade,
// que deverá ser lida. Para testar se a pessoa é de “Campinas”, por exemplo, é necessário definir uma struct
// separada para endereço, como apresentado na aula. Primeiro defina as structs: endereço e cliente. Faça a
// leitura de N e declare o vetor de struct cliente. Faça a leitura das informações de N clientes. Faça a leitura de
// uma cidade de busca e imprima os dados dos clientes que são da cidade buscada. Para o exercício, considere
// para a struct endereço, apenas os campos: rua: string, número: int, cidade: string e uf: string. (GD:4)


struct Endereco{ //TIPO
    char rua[100];
    int num;
    char cidade[100];
    char uf[5];
};

struct Clientes{
    char cpf[100];
    char nome[100];
    Endereco loc; //LOC POSSUI TODAS OS ATRIBUTOS DE ENDERECO
    int num_filhos;
};

int main (void){
    int n,i;

    cout << "Digite a quantidade de pessoas: " << endl;
    cin >> n;
    Clientes vet[n];
    cin.ignore();

    for(i=0;i<n;i++){
        cout << "Digite o cpf: " << endl;
        cin.getline(vet[i].cpf,100);
        cout << "Digite o nome: " << endl;
        cin.getline(vet[i].nome,100);
        cout << "Digite as informacoes do endereco: " << endl;
        cin.getline(vet[i].loc.rua,100);
        cout << "Digite as informacoes do endereco: " << endl;
        cin >> vet[i].loc.num;
        cin.ignore();
        cout << "Digite as informacoes do endereco: " << endl;
        cin.getline(vet[i].loc.cidade,100);
        cout << "Digite as informacoes do endereco: " << endl;
        cin.getline(vet[i].loc.uf,5);
        cout << "Digite o numero de filhos: " << endl;
        cin >> vet[i].num_filhos;
    }

    for(i=0;i<n;i++){
        if (strcmp(vet[i].loc.cidade,"campinas") == 0 ){ // 0 eh IGUAL e 1 DIFERENTE
            cout << "CPF: " << vet[i].cpf << endl;
            cout << "Nome: " << vet[i].nome << endl;
            cout << "Endereço: " << vet[i].loc.rua << ", " << vet[i].loc.num << endl;
            cout << "Cidade: " << vet[i].loc.cidade << ", UF: " << vet[i].loc.uf << endl;
            cout << "Número de filhos: " << vet[i].num_filhos << endl;          
            } 
    }

    return 0;
}