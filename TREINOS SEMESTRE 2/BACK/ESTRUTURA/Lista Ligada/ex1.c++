#include <iostream>
#include <stdio.h>
#include <cmath>
#include <iomanip>
#include <cstdlib>

using namespace std;

// Escreva  um  programa  que  crie  um  vetor  dinâmico,  de  reais,  de  N  posições  (o 
// tamanho  do  vetor,  N,  e  os  dados  do  vetor  devem  ser  fornecidos  pelo  usuário)  e 
// encontre o menor e o maior elemento. Porém, ao invés de guardar o índice ou o valor 
// em uma variável estática, crie dois ponteiros que apontem para as respectivas 
// posições do vetor dinâmico. Veja o exemplo abaixo, com um vetor de 10 posições:   

int main()
{
    int n;
    float *vet;
    int i;
    float *menor, *maior; // Declaramos vet,menor,maior como ponteiros pois os valores serao alocados por enderecos futuros ( dinamico ) e nao fixamente ( estatico )

    cout<<"Digite o tamahho do vetor";
    cin >> n;

    vet = (float*) calloc(n, sizeof(float)); // Criacao de um vetor de alocacao dinamica. Seu tamanho sera = n do typo float

    for(i=0;i<n;i++){
        cin >> vet[i];
    }

    menor = &vet[0]; //O valor da variavel menor eh = ao endereco da posicao 0 do vet, menor esta apontando para o endereco da posicao 0 do vet e sera seu valor
    maior = &vet[0]; //O valor da variavel maior eh = ao endereco da posicao 0 do vet, maior esta apontando para o endereco da posicao 0 do vet e sera seu valor

    for (i = 1; i < n; i++) {
        if (vet[i] > *maior) { // Verifica se o valor do vet na posicao i sera maior que o ponteiro de maior. ( *maior esta apontando, neste momento, para  &vet[0] )
            maior = &vet[i]; // Retiramos o * do ponteiro maior pois estamos atribuindo um novo endereco ( um novo valor ) para este ponteiro.
        }
        if (vet[i] < *menor) { // Verifica se o valor do vet na posicao i sera maior que o ponteiro de menor. ( *menor esta apontando, neste momento, para  &vet[0] )
            menor = &vet[i]; // Retiramos o * do ponteiro menor pois estamos atribuindo um novo endereco ( um novo valor ) para este ponteiro.
        }
    }

    cout << "Menor elemento: " << *menor << endl;
    cout << "Maior elemento: " << *maior << endl;

    free(vet);

    return 0;
}



    


