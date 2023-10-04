#include <iostream>
#include <string.h>
#include <stdio.h>

using namespace std;

// 02. Construir um programa que define uma struct aluno com os campos: (ra: string,
// nome: string, nota: float), descobre qual dos alunos possui nota maior e imprime
// os dados apenas do aluno que possui maior nota. Dividir o programa em módulos:
// a. Função 1: leitura de N e das informações dos N alunos.
// b. Função 2: recebe os dados dos N alunos e descobre qual possui a maior
// nota. TODOS os dados do aluno que possuir maior nota devem retornar
// pelo return. Não retornar apenas a posição que está no vetor.
// c. Função 3: imprime as informações de UM aluno.
// d. Main: define as variáveis do problema e chama as funções. Caso tenha mais
// de um aluno com nota maior, retorne qualquer um deles. Definir o
// tamanho físico para 100 elementos.

struct aluno{
    char RA[20];
    char nome[20];
    float nota;
};

void ler_vetor( int *n, aluno vet[]){

    int i;

    cout << "Digite a quantidade de alunos: ";
    cin >> *n;

    for(i=0;i<*n;i++){
        cin.getline(vet[i].RA,20);
        cin.getline(vet[i].nome,20);
        cin >> vet[i].nota;
    }
}

aluno maior_nota(int n, aluno vet[]){

    int i,maior=0,k;
    for(i=0;i<n;i++){
        if(vet[i].nota > maior){
            maior = vet[i].nota;
            k = i; //Salvar posição da onde o aluno com maior nota esta
        }
    }
    return vet[k]; //Imprime todos os dados do aluno que esta na posição k que é a posição i que possui as infos do aluno com maior nota
}

void imprime_info(aluno a){
    cout << a.RA << endl;
    cout << a.nome << endl;
    cout << a.nota << endl;
}


int main() {

    int n;
 
    return 0;
}
