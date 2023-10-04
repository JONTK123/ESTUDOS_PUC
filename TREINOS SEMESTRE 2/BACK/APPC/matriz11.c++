#include <iostream>
#include <stdio.h>
#include <cmath>
#include <iomanip>

using namespace std;

// Fazer um programa que faz a leitura de uma matriz de inteiros A, de dimensão NxM (os
// valores de N e M devem ser lidos). Calcula e imprime a somatória dos elementos da K-ésima
// linha da matriz, onde K deve ser lido

int main() {
    
    int n, m, i, j, s=0, k, a;
    cout << "Digite o tamanho N (linha) da matriz: "; //Definir primeiro paramentos ( linhas )
    cin >> n;
    cout << "Digite o tamanho M (coluna) da matriz: ";
    cin >> m;

    int matriz[n][m]; //Criacao da matriz
    
    cout << "Digite a linha que deseja somar: ";
    cin >> k;

    for(i = 0; i < n; i++){ //For das linhas
       for(j = 0; j < m; j++){ //For das colunas
            cout << "Digite o Elemento [" << (i +1) << "][" << (j + 1) << "]: ";
            cin >> matriz[i][j];  
     }
    }

    // ----------------------------------------------------------------------------------

    cout << "Matriz: " << endl;
    for(i = 0; i < n; i++){ //PERCORRE LINHA
       if (i == k - 1){ //CONFERE SE A LINHA == AO K-ESIMO TERMO, SE FOR, K SEMPRE > I POR INICIAR POR 0
            for( j = 0; j < m; j++){ // PERCORRE AS COLUNAS E ->
                s = s + matriz[i][j]; //SOMA OS VALORES DA COLUNA DAQUELA LINHA
            }
       }
       for(j = 0; j < m; j++){ //PERCORRE AS COLUNAS DA LINHA E PRINTA
            cout << matriz[i][j] << " "; //PRINTA
     }
     
        cout << endl;
    }
    
    cout << s;

    return 0;

}