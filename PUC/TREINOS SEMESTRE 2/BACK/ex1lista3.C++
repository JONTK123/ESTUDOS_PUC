#include <iostream>
#include <stdio.h>
#include <cmath>
#include <iomanip>

using namespace std;

int main() {

    // Construir um programa que faz a leitura de um número inteiro qualquer e imprime se ele é múltiplo de 5 ou não

    int x;
    cout << "Digite um numero: ";
    cin >> x;

    if (x % 5 == 0) {
        cout << "Numero é divisivel por 5";
    } else {
        cout << "Numero não é divisel por 5";
    }

    return 0;
}
