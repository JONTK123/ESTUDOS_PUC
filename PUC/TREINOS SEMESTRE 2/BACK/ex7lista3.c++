#include <iostream>
#include <stdio.h>
#include <cmath>
#include <iomanip>

using namespace std;

int main() {
    
    int n;
    float soma = 0;

    do
    {
        cout<<"Digite um valor n, entre 10 e 100: ";
        cin>>n;

    } while (n < 10 || n > 100);

    for (int i = 1; i <= n; i++) {
        soma += sqrt(i);     
    }

    cout << "\n" << soma;

    return 0;
}



