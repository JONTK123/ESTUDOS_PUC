#include <iostream>
#include <stdio.h>
#include <math.h>

using namespace std;

//Ex 9

int main()
{
    float x, a;
    int y, b;
    cout<<"Digite um numero X REAL maior que 0: "; cin>> x;
    cout<<"Digite um numero Y INTEIRO maior que 0: "; cin>> y;

    a = sqrt(x);
    b = sqrt(y);

    cout<<"A raiz do numero real eh: " << a;
    cout<<"A raiz do numero inteiro eh: "<< b;

    return 0;
}