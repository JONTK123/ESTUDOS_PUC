#include <iostream>

using namespace std;

int main()
{

    int n, s = 0;
    cout<<"Digite o tamanho do vetor: ";
    cin>> n;
    int vet[n];


    for(int i=0;i<n;i++){
        cout<<"Digite o valor: " << i + 1 << " do vetor: ";
        cin>>vet[i];
    }

    for(int i=0;i<n;i++){
        if ( vet[i] % 5 == 0){
            s += vet[i];
        }
    }

    for(int i=0;i<n;i++){
        cout<<vet[i]<<"\n";
    }

    cout<<"Somatorio: "<<s<<endl;

    return 0;
}
    
