#include <iostream>
#include <stdio.h>
#include <cmath>
#include <iomanip>

using namespace std;

int main()
{
    float op1, op2, res;
    char opc, resp;
    cout<<(fixed)<<setprecision(2);

    do
    {
        cout << "Deseja realizar uma nova operação? (s/n): ";
        cin >> resp;

        if (resp == 'n') 
            break;

            cout << "Digite a operação: Ex ( x ) + ( x ): ";

            cin >> op1 >> opc >> op2;

        switch (opc)
        {
        case '+':
            res = op1 + op2;
            cout << "Resultado: " << res << endl;  

            break;


        case '-':
            res = op1 - op2;
            cout << "Resultado: " << res << endl;  
            break;

        case '*':
            res = op1 * op2;
            cout << "Resultado: " << res << endl;  
            break;

        case '/':
            if (op2 == 0)
            {
                cout << "Não existe divisão por 0" << endl;  
            }
            else
            {
                res = op1 / op2;
                cout << "Resultado: " << res << endl;  

            }
            break;

        default:
            cout << "Operação inválida..." << endl;  
        }
        } while(resp == 's');
     
    return 0;
}
