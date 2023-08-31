#include <iostream>
#include <stdio.h>
#include <math.h>

using namespace std;

//Ex 10

int main()
{
  
    float a, b, c, d, e, f, x, y, r1, r2;
    cout << "Digite um numero a: "; cin >> a;
    cout << "Digite um numero b: "; cin >> b;
    cout << "Digite um numero c: "; cin >> c;
    cout << "Digite um numero d: "; cin >> d;
    cout << "Digite um numero e: "; cin >> e;
    cout << "Digite um numero f: "; cin >> f;

    x = (c * e - b * f) / (a * e - b * d);
    y = (a * f - c * d) / (a * e - b * d);

    r1 = (a * y) + (b * y);  
    r2 = (d * x) + (e * y);  

    cout << "Resultado r1: " << r1 << endl;
    cout << "Resultado r2: " << r2 << endl;
    return 0;
}