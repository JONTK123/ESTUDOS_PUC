#include <iostream>

using namespace std;

int main()
{

    int n, j;
    cout<<"Digite o tamanho do vetor: ";
    cin>>n;
    int vet[n];
    
    for ( int i=0;i<n;i++){
        cout<<"Digite os valores: " << i + 1 << " do vetor: ";
        cin >> vet[i];
    }

    for ( int i=0;i<n;i++){
        if (vet[i] < vet[i+1]){ //AO FINAL DO VETOR, A POSIÇÃO I+1 NAO EXISTE, MAS A COMPARAÇÃO OCORRE E ELE DA COMO VERDADEIRO
            j = 0;
        } else {
            j = 1;
            break; //SE O ANTERIOR FOR MAIOR QUE O PROXIMO ELE AUTOMATICAMENTE QUEBRA O PROGRAMA E JA CONSIDERA DECRESCENTE.

        }
    }
    
    if ( j== 0 ){
        cout<<"Está em ordem crescente";
    } else {
        cout<<"Está em ordem decrescente";
    }

    return 0;
}
    
