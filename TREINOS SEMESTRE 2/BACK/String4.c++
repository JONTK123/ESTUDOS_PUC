#include <iostream>
#include <cstring> // Include the correct header for string operations

using namespace std;

int main()
{
    char string[10];
    char stringi[10];
    int identificador;

    cout << "Digite o nome da pessoa: ";

    cin.getline(string, 10);

    for (int i = 0; i < strlen(string); i++) {
        stringi[i] = string[strlen(string) - i - 1]; //Logica para fazer o i ao contrario
    }
    
    for (int j = 0; j < strlen(string); j++) {
        if (stringi[j] == string[j]) {
            identificador = true;
        }
    }

    if (identificador == true) {
        cout << "Polindromo";
    } else {
        cout << "Nao eh polindromo";
    }

    return 0;
}

