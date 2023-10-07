#include <iostream>
#include <stdio.h>
#include <cmath>
#include <iomanip>
#include <cstdlib>

using namespace std;

// Escreva  um  programa  que  crie  um  vetor  dinâmico  para  reais,  representando  as 
// notas de alunos, de n posições. Verificar a nota que mais se repete. Caso tenha mais de 
// uma delas que se repete, escolher a maior entre  elas. Por exemplo, num conjunto  de 
// N=50  notas,  supor  que  as  notas:  8,5  e  5,5  são  as  notas  que  mais  se  repetem,  por 
// exemplo, ambas repetem 15 vezes. Então escolher, a nota 8,5. Imprimir os elementos 
// do  vetor  e  a  nota  que  mais  se  repete.  O  programa  deve  ter  a  seguinte  divisão  de 
// módulos: 
 
// • função 1: ler N, alocar dinamicamente o vetor de N reais, ler as informações do 
// vetor. Comunicar o vetor pelo return e o N pela lista de parâmetros; 
// • função 2: receber o valor de N, os valores do vetor e encontra a nota que mais 
// se repete. A comunicação dessa nota deve ser pelo return; 
// • função 3: receber o valor de N, os valores do vetor e faz a impressão do vetor; 
// • main:  declarar  as  variáveis  do  problema,  chamar  as  funções  e  imprimir  a  nota 
// que mais se repete encontrada, após a impressão dos elementos do vetor. 

// ---------------------------------------------------------------------------------------------------------------

//Se tera return, nao precisa entrada de parametro do vet. 
//int * ler_n pois o return dessa função, será um ponteiro
int* ler_n(int *n){  // *n ponteiro, pois o endereço dele está fora da função, e sempre temos que ficar apontando para seu endereço

    int i;
    int *vet; //Declaração de um ponteiro de vet do tipo inteiro. NAO POSSUI UM ENDEREÇO AINDA

    cout << "Digite quantas notas deseja ler 10 POR FAVOR EU IMPLORO: \n";
    cin >> *n;

    vet = (int *)malloc(*n * sizeof(int)); //Alocação dinamica do ponteiro vet, criação de um vetor, não utiliza PONTEIRO * pois agora ele possui um ENDEREÇO

    for(i=0;i<*n;i++){
        cout << "Digite notas de 0 a 10 POR FAVOR EU IMPLORO: \n";
        cin >> vet[i];
    }

 return vet; //Retorna vet sem * pois ele ja possui endereço 

}

int nota_repete(int n, int *vet){
    int frequencia[11] = {0}; //Terceiro vetor das 11 notas ( 0 a 10 ) iniciando todos os valores com 0
    int nota_mais_repetida;
    int mais_repetida = 0;

    for (int i = 0; i < n; i++) { //Assumindo que o usuario insira 10 notas:
        frequencia[vet[i]]++; 
    }

    for (int i = 0; i < 11; i++) { // Percorra todas as notas de 0 a 10
        if (frequencia[i] > frequencia[mais_repetida]) { // Verifique se a frequência é maior que a maior frequência atual
            mais_repetida = i; // Se sim, atualize a nota mais repetida
        }
    }
    return mais_repetida;
}

void imprime_vetor(int n, int *vet){
    cout << "Elementos do vetor:" << endl;
    for (int i = 0; i < n; i++) {
        cout << vet[i] << " ";
    }
    cout << endl;
}

int main()
{
   
    int n;
    int *vet_oficial; //Criação de uma variavel ponteiro *vet do tipo inteiro pois ira apontar para o endereço
    int nota_repetida; //Criação de uma variavel normal pois ela indicara apenas a nota que mais repetiu. SEM PONTEIRO NEM NADA

    vet_oficial = ler_n(&n); //Atribuição de endereço para a variavel, vet_oficial
    nota_repetida = nota_repete(n,vet_oficial); //n agora ja possui um um valor atrelado ao seu endereço atraves do endereço + envio do endereço do vet_oficial para usarmos na função
    imprime_vetor(n,vet_oficial);

    cout << "A nota que mais se repete é: " << nota_repetida << endl;

    free(vet_oficial);

    return 0;
}



    























