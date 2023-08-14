#include <iostream>
#include <stdio.h>
#include <math.h>

using namespace std;

//Ex 10

int main()
{
    int y;
    float x, r;
    cout<<"Digite um numero X ( maior do que 0 ): "; cin>> x;
    cout<<"Digite um numero y ( inteiro e maior que 0): "; cin>> y;
    r = pow(x,y);
    cout<<"O resultado da potencia eh igual a: "<< r;

    return 0;
}