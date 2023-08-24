#include <iostream>
#include <stdio.h>
#include <cmath>
#include <iomanip>

using namespace std;

int main(){

    float salario, novoSalario;
    int plano, i;

    cout<<"Digite o salario do funcionario e seu plano: ";
    cin>>salario>>plano;

    switch (plano)
    {

    case 1:
        novoSalario = salario + (salario * 10/100);
        cout<<novoSalario;
        break;

    case 2:
        novoSalario = salario + (salario * 15/100);
        cout<<novoSalario;
        break;

    case 3:
        novoSalario = salario + (salario * 20/100);
        cout<<novoSalario;
        break;
    
    default:
        cout<<"Não existe esse plano no banco de dados...";
        break;

    }
    return 0;
}
