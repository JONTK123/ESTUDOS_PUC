#include <iostream>
#include <stdio.h>
#include <cmath>
#include <iomanip>

using namespace std;

int main() {
    
    int N, X;
    float soma = 0;
    do
    {
        cout << "Digite o numero de vzes para realizar a somatoria: ";
        cin >> N;

    } while (N < 0 || N > 50);

    cout << "Digite o valor de X: ";
    cin >> X; 

    for(int i = 1; i <= N; i++){
        soma += (pow(X,i) / tgamma(i + 2));
    }

    cout << soma;

    //cout << "Digite o numero de vzes para realizar a somatoria: ";
    //cin >> N;

    //while (N < 0 || N > 50)
    //{
        //cout << "Digite o numero de vzes para realizar a somatoria: ";
        //cin >> N;
    //}
    
    //while(true){

    //cout << "Digite o numero de vzes para realizar a somatoria: ";
    //cin >> N;

    //if ( N > 0 && N < 50){
        //break;
    //} else {
        //cout << "\nNumero invalido, Tente novamente...";
    //}
    //}

   

    
   

    return 0;
}
