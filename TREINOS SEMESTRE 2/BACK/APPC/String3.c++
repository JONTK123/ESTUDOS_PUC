#include <stdio.h>
#include <iostream>
#include <math.h>
#include <string.h>

// Construir um programa que faz a leitura de uma string e faz a troca dos ‘a’s por ‘o’s e dos
// ‘e’s por ‘u’s. Trocar na mesma string. Imprimir a string final.

using namespace std;


int main()
{
    char string[10];

    cout<<"Digite o nome da pessoa: ";

    cin.getline ( string,10 );

    for(int i=0;i<strlen(string);i++){
        if(string[i] == 'a'){
            string[i] = 'o';
        } else if(string[i] == 'e'){
            string[i] = 'u';
        }
    }

    cout << "String modificada: " << string << endl;

    return 0;
}
    
