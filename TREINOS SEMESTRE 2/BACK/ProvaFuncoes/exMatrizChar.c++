#include <stdio.h>
#include <iostream>
#include <string.h>

using namespace std;
int main (void){
    int n, i;
    cout << "Digite o numero de cidade que deseja ler: ";
    cin >> n;
    char cidade [n][31];
    char nomeCidade[31];
    cin.ignore();

    for(i = 0; i < n; i++){
        cout << "Digite o nome da cidade: ";
        cin.getline(cidade[i], 31);
    }

    cout << "Digite o uma cidade para verificar se ela esta no vetor: ";
    cin.getline(nomeCidade, 31);

    for(i = 0; i < n; i++){
        if(strcmp(nomeCidade, cidade[i]) == 0){
            cout << "Cidade " << nomeCidade << " consta da lista" << endl;
            break;
        }
        else if(nomeCidade[0] == '*'){
            break;
        }
        else if(i == n-1){
            cout << "Cidade " << nomeCidade << " não consta da lista" << endl;
        }
    }
    return 0;
}