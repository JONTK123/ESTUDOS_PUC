#include <stdio.h>
#include <iostream>
#include <math.h>

using namespace std;

// Fazer um programa que faz a leitura de dois vetores X e Y, ambos com N inteiros (N
// deverá ser lido). Gera um terceiro vetor Z, da seguinte forma: nas posições pares de Z
// armazenar os valores das posições pares de X e nas posições ímpares de Z, armazenar os
// valores das posições ímpares de Y. Imprimir os vetores lidos, X e Y e, o vetor Z

int main()
{

    int n,z, i;
    cout<<"Digite o tamanho do vetor: ";
    cin>>n;

    int vetx[n];
    int vety[n];
    int vetz[n];
    cout << endl;
    for(i = 0; i<n; i++){
        cout<<"Digite o valor " << (i + 1) << " do vetor x: ";
        cin>>vetx[i];
    }

    for(i = 0; i<n; i++){
        cout<<"Digite o valor " << (i + 1) << " do vetor y: ";
        cin>>vety[i];
    }

    // -----------------------------------------------------------

    for (i = 0; i<n; i++){
        if (i % 2 == 0){ // POSICAO DO VETOR
            vetz[i] = vetx[i];
        } 
        else {
            vetz[i] = vety[i];
        }
    }

    cout << "Vetor X: "; 
    for(i = 0; i<n; i++){
        cout << vetx[i];
    }
    cout << endl;

    cout << "Vetor Y: ";
    for(i = 0; i<n; i++){
        cout << vety[i];
    }
    cout << endl;
    
    cout << "Vetor Z: ";
    for(i = 0; i<n; i++){
        cout << vetz[i];
    }
    
    return 0;
}
    
