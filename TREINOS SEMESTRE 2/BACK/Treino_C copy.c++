#include <iostream>

using namespace std;

int main()
{
    cout<< "Bom dia, alunos! \n";
    cout<< "Aula de APPC";
    cout<< "Quarta feira"<<endl;
    cout<< "De ago " <<endl<< "\n sto" <<endl;

    int x;
    cout<< "Digite um numero inteiro:";
    cin>> x;
    cout<<"\n\n ---- Vaor Digitado : " << x << endl;

    int y;
    cout<< "Digite o segundo numero inteiro:";
    cin>> y;
    cout<<"\n\n ---- Vaor Digitado : " << y << endl;

    int soma;
    soma = x + y;
    cout<< "\n\n --- RESULTADO: ";
    cout<< x << " + " << y << " = " << soma;

    return 0;
}