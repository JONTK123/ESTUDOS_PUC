#include <iostream>
#include <stdio.h>
#include <cmath>
#include <iomanip>

using namespace std;

// Quer q eu digite X, N vezes e determine dentre os numeros X q eu digitei, qual o maior.

//int main() {

    //int x,n,maior = 0;
    //cout<<"Digite uma quantidade de vzes para repetir: ";
    //cin>>n;

    //for (int i = 1; i <= n; i++){
        //cout<<"Digite o numero: ";
        //cin>>x;

        //if ( x > maior){
            //maior = x;
        //}
        //}

    //cout<<maior;
    //return 0;
//}

#include <iostream>

int main() {
    int n, maior = 0, x[10];

    do {
        cout << "Digite uma quantidade de vezes para repetir (entre 0 e 10 max): ";
        cin >> n;
    } while (n < 0 || n > 10);

    for (int i = 0; i < n; i++) { // Corrigido para começar de 0
        cout << "Digite o numero: ";
        cin >> x[i];
    }

    for (int i = 0; i < n; i++) { // Corrigido para começar de 0
        if (x[i] > maior) {
            maior = x[i];
        }
    }

    cout << maior;

    return 0;
}
