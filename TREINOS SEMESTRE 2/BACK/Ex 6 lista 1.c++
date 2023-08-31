#include <iostream>

using namespace std;

//Ex 6

int main()
{

    int dividendo,divisor, quociente, resto;
    cout<< "Digite o DIVIDENDO inteiro diferente de 0: " << endl;
    cin>>dividendo;
    cout<< "Digite o DIVISOR inteiro diferente de 0: " << endl;
    cin>>divisor;

    quociente = dividendo / divisor;

    resto = dividendo % divisor;

    cout<< "Quociente: " << quociente << " Resto: " << resto << endl;
    cout<< "Dividendo: " << dividendo << " Divisor " << divisor << endl;

    return 0;
}