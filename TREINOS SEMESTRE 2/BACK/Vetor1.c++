#include <iostream>

using namespace std;

int main()
{

    int n,k;

    cout<<"Digite o tamanho do vetor: ";
    cin>>n;

    int vet[n];
    int vetM[n];

    for(int i=0;i<n;i++){
        cout<<"Digite os valores " << i + 1 << " do vetor: ";
        cin>>vet[i];
    }

    cout<<"Digite o valor de K para multiplicar os numeros de cada posicao do vetor: ";
    cin>>k;

    for(int i=0;i<n;i++){
        vetM[i] = vet[i] * k;
        cout<<"\nOs valores do vetor multiplicados sao: "<<vetM[i];
    }

    return 0;
}
    
