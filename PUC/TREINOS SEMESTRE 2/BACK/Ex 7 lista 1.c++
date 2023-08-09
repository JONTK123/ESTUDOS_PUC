#include <iostream>

using namespace std;

//Ex 7

int main()
{

    float nota1, nota2, media;
    cout<< " Digite a nota 1: ";
    cin>> nota1;
    cout<< " Digite a nota 2: ";
    cin>> nota2 ;

    media = ( 4*nota1 ) + ( 6*nota2 ) / ( 4 + 6 );

    cout<< "N1: " << nota1 << " N2: " << nota2 << " Media: " << media << endl;

    return 0;
}