#include <iostream>

using namespace std;

// Função para calcular a média de um vetor
void calculaMedia(int n, int vet[]) {
    int s = 0;
    for (int i = 0; i < n; i++) {
        s += vet[i];
    }
    int m = s / n;
    cout << "A media do conjunto de numeros eh: " << m << endl;
}

// Função para ler os elementos do vetor
void lerVetor(int *n, int vet[]) {
    cout << "Digite a quantidade de numeros a serem somados: ";
    cin >> *n;

    cout << "Digite os numeros:" << endl;
    for (int i = 0; i < *n; i++) {
        cin >> vet[i];
    }
}

int main() {
    int N;
    int vet[100]; // DECLARAR PARA O VETOR NA MAIN UM TAMAHNO ESPECIFICO, MESMO QUE VC VA MEXER NISSO DPS
    lerVetor(&N, vet);
    calculaMedia(N, vet);
    return 0;
}
