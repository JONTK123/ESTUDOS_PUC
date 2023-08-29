#include <iostream>
#include <stdio.h>
#include <cmath>
#include <iomanip>

using namespace std;

int main(){

    float media_sal_pop, media_num_filhos, maior_sal = 0,percent1500,salario,filhos, num_total_pessoas = 0, salarioSoma = 0, filhosSoma = 0;
    char resp = 's';
    int j = 0;

    while(resp == 's'){

        cout<<"Deseja iniciar a pesquisa? responda (s ou n): ";
        cin>>resp;

        if (resp == 'n'){
            cout<<"Desligando...";
            break;
        }

        cout<<"Digite o salario e a quantidade de filhos: ";
        cin>>salario>>filhos;

        if (resp == 's'){
            num_total_pessoas++;
        }

        if ( salario > maior_sal){
            maior_sal = salario;
        }

        if (salario > 1500){
            j++;
            percent1500 =  ( j / num_total_pessoas ) * 100;
        }

        salarioSoma += salario;
        filhosSoma += filhos;
    }

        media_sal_pop = salarioSoma / num_total_pessoas;
        media_num_filhos = filhosSoma / num_total_pessoas;
    
    cout<<"\n\nA media de salario da popluação: "<<media_sal_pop;
    cout<<"\nA media do numero de filhos da popluação: "<<media_num_filhos;
    cout<<"\nO maior salario dentre a população: "<<maior_sal;
    cout<<"\nA porcentagem da população com salario maior que R$1500 é: "<<percent1500<<"%";

    return 0;
}
