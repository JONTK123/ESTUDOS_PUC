#include <iostream>
#include <stdio.h>
#include <cmath>
#include <iomanip>

using namespace std;

int main() {

float a,b,c,x1,x2,delta;
cout<<"Digite os valores de A B C:";
cin>> a >> b >> c;

delta = (b*b) - 4*(a*c);

if (delta >= 0){

    x1 = ((-b) + (sqrt(delta))) / (2*a);

    x2 = ((-b)) - ((sqrt(delta))) / (2*a);

    cout<<"Delta: " << delta << endl;
    cout<<"Raiz 1: " << x1 << endl;
    cout<<"Raiz 2: " << x2 << endl;

} else {

    cout<<"Não existem raizes quando delta < 0... tente novamente";

}
    return 0;
}
