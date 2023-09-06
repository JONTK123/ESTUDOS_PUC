#include <stdio.h>
#include <iostream>
#include <math.h>

using namespace std;

// Fazer um programa que faz a leitura de um vetor X, com N número inteiros (N deverá ser
// lido). Calcula a somatória dos valores das posições ímpares do vetor. Imprimir o vetor lido
// e a soma calculada.

int main()
{
    int n, s=0;
    cout << " Digite o tamanho do vetor: ";
    cin >> n;
    int vet[n];
   
    for ( int i = 0; i < n; i++ ){
        cin >> vet[i];
    }

    for ( int i = 0; i < n; i++ ){
        if ( i % 2 == 1){ 
            s += vet[i];
        }
    }

    cout << "Vetor: ";
    for ( int i = 0; i < n; i++ ){
        cout << vet[i] << " ";
    }
    cout << endl;
    cout << "Soma dos valores impares: " << s << endl;
    return 0;
}
    
