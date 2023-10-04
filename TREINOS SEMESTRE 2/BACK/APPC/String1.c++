#include <stdio.h>
#include <iostream>
#include <math.h>

using namespace std;

// Construir um programa que faz a leitura do nome de uma pessoa e imprima o nome lido
// na frase: “Bom dia <nome lido>! Tudo bem?”
// Por exemplo se o nome lido for “Peter Pan” a frase impressa deverá ser:
// “Bom dia Peter Pan! Tudo bem?


int main()
{

    int n;
    char nome[30];

    cout<<"Digite o numero teste: ";
    cin >> n;

    cin.ignore( ); ; // USE APENAS DEPOIS DE UM CIN DE UM NUMERO PADRAO.

    cout<<"Digite o nome da pessoa: ";

    cin.getline ( nome,30 );

    cout << nome; // APENAS PERCORRE UM FOR QUANDO FOR UMA LISTA DE STRING.

    cout << "Bom dia " << nome << "! Tudo bem? " << endl; 


    return 0;
}
    
