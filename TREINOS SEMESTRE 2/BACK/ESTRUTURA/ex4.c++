#include <iostream>
#include <stdio.h>
#include <cmath>
#include <iomanip>
#include <cstdlib>

using namespace std;

// Escreva um programa que crie uma struct aluno (ra – inteiro; nome – string; nota – 
// real)  aloca  dinamicamente  n  posições,  para  receber  as  informações  de  n  alunos. 
// Calcular  o  valor  médio  das  notas.  Imprimir  todos  os  dados  dos  alunos  e  o  valor 
// encontrado. O programa deve ter a seguinte divisão de módulos: 
// a. Função1:  ler  N,  alocar  dinamicamente  o  espaço  para  os  alunos,  ler  as 
// informações.  Comunicar  as  informações  pelo  return  e  o  N    pela  lista  de 
// parâmetros; 
// b. Função2:  receber  o  valor  de  N,  os  valores  dos  alunos  e  calcular  o  valor 
// médio das notas. A comunicação do valor médio deve ser pelo return; 
// c. Função3: receber o valor de N, os valores dos alunos e fazer a impressão de 
// todos os alunos no formato de tabela; 
// d. main:  declarar  as  variáveis  do  problema,  chamar  as  funções  e  imprimir  o 
// valor médio.

struct aluno {
    int ra;
    char nome[50];
    float nota;
};

aluno* ler_vet(int *n) { // Return vai ser um PONTEIRO e sera do tipo STRUCT
    int i;
    cout << "Digite o tamanho do vetor: ";
    cin >> *n;

    aluno* vet = (aluno*)malloc(*n * sizeof(aluno)); // Atribuição de endereço e criação de um vetor de struct

    for (i = 0; i < *n; i++) {
        cout << "Digite o RA do aluno " << i + 1 << ": ";
        cin >> vet[i].ra;
        cout << "Digite o nome do aluno " << i + 1 << ": ";
        cin >> vet[i].nome;
        cout << "Digite a nota do aluno " << i + 1 << ": ";
        cin >> vet[i].nota;
    }

    return vet;
}

float calcula_media(aluno *vet, int n){ // Como parametro, recebe ponteiro de VET, apontando para o endereço que esta na main do tipo ALUNO ( struct )
    int soma = 0;
    for(int i=0;i<n;i++){
        soma += vet[i].nota;
    }

    return soma/n;
}

void imprime_vetor(aluno *vet, int n){ // Como parametro, recebe ponteiro de VET, apontando para o endereço que esta na main do tipo ALUNO ( struct )
    cout << "RA     Nome                 Nota" << endl;
    for (int i = 0; i < n; i++) {
        cout << left << setw(7) << vet[i].ra << " ";
        cout << left << setw(20) << vet[i].nome << " ";
        cout << fixed << setprecision(2) << vet[i].nota << endl;
    }
}

int main(){
    int n;
    float media;
    aluno *vet;

    vet = ler_vet(&n); // Aqui  atribuiu um endereço para o vetor
    media = calcula_media(vet,n); // Aqui, enviamos o endereço do vetor (& - implicitamente) 
    imprime_vetor(vet,n);

    return 0;
}



    























