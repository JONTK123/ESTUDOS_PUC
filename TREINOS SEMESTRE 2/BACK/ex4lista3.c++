#include <iostream>
#include <stdio.h>
#include <cmath>
#include <iomanip>

using namespace std;

int main() {

    float n1,n2,p1,p2,media;
    cout<<"Digite a nota do aluno 1 e seu peso 1: ";
    cin>> n1 >> p1;
    cout<<"Digite a nota do aluno 2 e seu pedo 2: ";
    cin>> n2 >> p2;

    media = ((n1*p1) + (n2*p2)) / (p1 + p2);
    cout << "\n" << media;
    if(media >= 7) {
        cout<<"Aprovado";
    } else {
        cout<<"Reprovado";
    }

    if(media >= 10){
        cout<<"Aprovado com distinção";
    }

    return 0;
}
