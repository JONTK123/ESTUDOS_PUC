#include <iostream>
#include <stdio.h>
#include <math.h>
using namespace std;

int main()
{
    int menu;
    cout<<"Bem vindo ao menu, opcoes:\n1- Inserir\n2- Excluir"<<endl;
    cout<<"Digite o numero par ao menu desejado: ";
    cin>>menu;
    switch(menu)
    {
    case 1: cout<<"Inserido"; break;
    case 2: cout<<"Excluido"; break;
    }
    return 0;
}   