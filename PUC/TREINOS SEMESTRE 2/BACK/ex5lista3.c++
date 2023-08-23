#include <iostream>
#include <stdio.h>
#include <cmath>
#include <iomanip>

using namespace std;

int main() {

    float salario;
    cout << "Digite o Salario do funcionario: ";
    cin >> salario;

    if (salario < 500){
        salario += ((salario * 15 / 100));
        cout<<"\nAumento de 15%\n";
        cout<<salario;
    }
    else if (salario >= 500 && salario <= 1000){ 
        salario += ((salario * 10 / 100));
        cout<<"\nAumento de 10%\n";
        cout<<salario;
    }
    else{
        salario += ((salario * 5 / 100));
        cout<<"Aumento de 5%\n";
        cout<<salario;
    }

    return 0;
}
