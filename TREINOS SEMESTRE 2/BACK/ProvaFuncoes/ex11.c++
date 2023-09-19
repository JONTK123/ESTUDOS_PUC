#include <iostream>
#include <cstring>

using namespace std;

void ler_frase(char f[]) {
    cin.getline(f, 100);
}

void intercala(char f1[], char f2[], char inter[]) {
    int i, j, k, c1 = strlen(f1), c2 = strlen(f2);

    for (i = 0, j = 0, k = 0; i < c1 && j < c2; i++, j++) {
        inter[k] = f1[i];
        k = k + 1;
        inter[k] = f2[j];
        k = k + 1;
    }
    inter[k] = '\0';

    // Adicione o restante de f1 a inter
    while (i < c1) {
        inter[k] = f1[i];
        k++;
        i++;
    }

    // Adicione o restante de f2 a inter
    while (j < c2) {
        inter[k] = f2[j];
        k++;
        j++;
    }
    inter[k] = '\0'; // Adicione o caractere nulo ao final novamente
}

int main() {
    char frase1[100], frase2[100], frase3[200];

    ler_frase(frase1);
    ler_frase(frase2);

    intercala(frase1, frase2, frase3);

    cout << "Frase lida\n"; 
    cout << frase1 << endl;
    cout << "Frase intercalada\n";
    cout << frase3 << endl;

    return 0;
}
