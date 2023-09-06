#include <iostream>
#include <stdio.h>
#include <cmath>
#include <iomanip>

using namespace std;

// Uma matriz A é simétrica se:
// 1º.) ela tiver dimensão NxN;
// exemplo:
// 2º.) A[i][j] for igual a A[j][i]
// Fazer um programa que faz a leitura de uma
// matriz de inteiros A, de dimensão NxN (N deve
// ser lido). Imprime a matriz lida e uma mensagem se ela é simétrica ou não.

// 1 3 5
// 3 4 7
// 5 7 6


int main() {
    
    int n,m,i,j;

    cout << "Digite a linha da matriz: ";
    cin >> n;
    cout << "Digite a coluna da matriz: ";
    cin >> m;

    int matriz[n][m];

    if ( n == m){
        cout<<"Matriz Quadrada\n";
    

    for(i = 0; i < n; i++){ //For das linhas
       for(j = 0; j < m; j++){ //For das colunas
            cout << "Digite o Elemento [" << (i + 1) << "][" << (j + 1) << "]: ";
            cin >> matriz[i][j];  
    }
    }

    for (int i = 0;i<n;i++){
        for (int j = 0;j<m;j++){
            cout << matriz[i][j] << " ";         
    }
    cout << endl;
    }

    cout << endl;
    }
    return 0;
}

