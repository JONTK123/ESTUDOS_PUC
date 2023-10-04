#include <iostream>

using namespace std;

int main()
{

   int n;
    cout<<"Digite o tamanho do vetor: ";
    cin>>n;
    int vet[n];
    int vetI[n];

    for(int i=0;i<n;i++){
        cout << "\nO valor da posicao: " << i + 1 << " Do vetor eh: ";
        cin >> vet[i];
    }

    for(int i = n - 1; i >= 0; i--){ // ENQUANTO o i for maior ou igual a 0, ele faz o for, n - 1 pois normalmente eh de 0 ate n - 1
        vetI[i] = vet[n - i - 1]; // Pensa que vc quer atribuir EXATAMENTE os valores para o vetor Inverso.

    
    for(int i=0;i<n;i++){
        cout << "\nO valor da posicao: " << i + 1 << " Do vetor INVERTIDO eh: " << vetI[i];
    }

    return 0;
}
    
