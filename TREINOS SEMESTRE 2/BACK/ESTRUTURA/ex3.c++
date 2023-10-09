#include <iostream>
#include <stdio.h>
#include <cmath>
#include <iomanip>
#include <cstdlib>

using namespace std;

// Escreva  um  programa  que  crie  um  vetor  dinâmico  para  reais,  representando  as 
// notas  de  alunos,  de  n  posições.  Supor  que  as  notas  aceitas  são  inteiras  ou  com 
// parte fracionária 0,5. Isto é, não tem parte fracionária com outros valores. 
// Acrescenta 0,5 ponto para todas as notas com valor quebrado. Imprimir os elementos  do  vetor  duas  vezes,  como  lido  e  depois  de  alterados  os  valores.  O 
// programa deve ter a seguinte divisão de módulos: 
// a. função 1: ler N, alocar dinamicamente o vetor, ler as informações do vetor. 
// Comunicar o vetor e o N pela lista de parâmetros; 
// b. função  2:  receber  o  valor  de  N,  os  valores  do  vetor,  acrescentar  0,5  ponto 
// somente nas notas quebradas.  
// c. função  3:  receber  o  valor  de  N,  os  valores  do  vetor  e  faz  a  impressão  do 
// vetor; 
// d. main: declarar as variáveis do problema; chama  a função1 para as leituras; 
// a função3 para a impressão dos elementos lidos; a função2 para a alteração 
// das notas quebradas e novamente a função3, agora, com as notas 
// alteradas.  Não  definir  dois  vetores,  apenas  um,  A  alteração  das  notas 
// deverá ser feita no próprio vetor lido.

void ler_notas(int *n, float* *notas){

    int i;

    cout << "Digite a quantidade de notas: " << endl;
    cin >> *n;

    *notas = (float*) calloc(*n, sizeof(float)); // Criacao de um vetor de alocacao dinamica. Seu tamanho sera = n do typo float
    
    cout << "Digite as notas dos alunos ( 0 A 10 ), pode inserir numero quebrado: " << endl;

    for(i = 0;i < *n; i++){
        cin >> (*notas[i]);
    }
}

void acrescentar(int n, float *notas){

    int i;

    for(i = 0;i < n; i++){
        if(notas[i] != int(notas[i])) //Não uso * pois ja usei nos parametros e meu programa ja sabe os endereços de cada posição do vetor
            notas[i] += 0,5;
    }
}

void imprime(int n, float *notas){
    cout << "Elementos do vetor:" << endl;

    for (int i = 0; i < n; i++) {
        cout << notas[i] << " ";
    }
    cout << endl;
}

int main()
{
    int n;
    float *notas;

    //Enviei o ENDEREÇO DO PONTEIRO notas pois o programa nao sabe ainda que o *notas eh um vetor, entao passamos seu endereco criado na main
    ler_notas(&n, &notas); 

    cout << "Imprime elemntos do vetor antes da mudança" << endl;
    imprime(n, notas);

    acrescentar(n, notas);

    cout << "Imprime elemntos do vetor depois da mudança" << endl;
    imprime(n, notas);

    return 0;
}



    























