#include <stdio.h>
#include <iostream>
#include <math.h>
#include <string.h>

using namespace std;

// Construir um programa que faz a leitura de uma string de no mínimo 4 e no máximo 10
// caracteres e imprima: o primeiro, o segundo, o penúltimo e o último caracteres


int main()
{

    char string[10];

    cout<<"Digite o nome da pessoa: ";

    cin.getline ( string,10 );

    for(int i = 4;  strlen(string); i++ ){
        cout << "Primeiro: " << string[i];
        cout << "Segundo: " << string[i + 1];
        cout << "Penultimo: " << string[strlen(string) - 1];
        cout << "Ultimo: " << string[strlen(string)];
    }

    return 0;
}
    
