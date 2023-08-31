#include <iostream>

using namespace std;

int main()
{

    int n;
    cout<<"Digite o tamanho do vetor: ";
    cin>> n;
    int vet[n], vet2[n], veti[2*n];

    for(int i=0;i<n;i++){
        cout<<"Digite o valor: " << i + 1 << " do vetor: ";
        cin>>vet[i];
    }

    cout<<"\n";

        for(int j=0;j<n;j++){
        cout<<"Digite o valor: " << j + 1 << " do vetor: ";
        cin>>vet2[j];
    }

    for(int y=0;y<(2*n);y++){

        for(int i=0;i<n;i++){
            veti[y] = vet[i];
    }
        for(int j=0;j<n;j++){
            veti[y] = vet[j];
    }

    for(int l=0;l<(2*n);l++){
        cout<<veti[l]<<"\n"<<endl;
    }
    
    return 0;

    }
}    
