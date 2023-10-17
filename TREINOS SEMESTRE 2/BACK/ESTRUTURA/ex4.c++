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

aluno* ler_vet(int *n) {
    int i;
    cout << "Digite o tamanho do vetor: ";
    cin >> *n;

    aluno* vet = (aluno*)malloc(*n * sizeof(aluno)); // Alocação dinâmica de um vetor de alunos

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

int main(){
    int n;
    float *vet;
    aluno al;

    vet = ler_vet(&n);




    return 0;
}



    























