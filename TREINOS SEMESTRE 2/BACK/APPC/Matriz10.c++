#include <iostream>
#include <stdio.h>
#include <cmath>
#include <iomanip>

using namespace std;

// Fazer um programa que faz a leitura de uma matriz de inteiros A, de dimensão NxM (os
// valores para N e M devem ser lidos). Calcula e imprime a somatória dos elementos pares da
// matriz. Imprimir a matriz lida e o valor somado.

int main() {
    
    int n,m,s=0,i,j;

    cout << "Digite o numero de linhas da matriz: ";
    cin >> n;
    cout << "Digite o numero de colunas da matriz: ";
    cin >> m;

    int matriz[n][m];

    for(i=0;i<n;i++){
        for(j=0;j<m;j++){
            cout << "Digite o Elemento [" << i + 1 << "][" << j + 1 << "]: ";
            cin >> matriz[i][j];
        }
    }

    for(i=0;i<n;i++){
        for(j=0;j<m;j++){
            if (matriz[i][j] % 2 == 0){
                s += matriz[i][j];
            }
        }
    }

    for(i=0;i<n;i++){
        for(j=0;j<m;j++){
            cout << matriz[i][j] << " ";
        }
        cout<<endl;
    }

    cout<<"O valor da soma dos elemento pares da matriz eh: " << s <<endl;
    
    return 0;
}
