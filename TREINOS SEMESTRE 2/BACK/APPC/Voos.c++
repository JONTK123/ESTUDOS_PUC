#include <stdio.h>
#include <iostream>
#include <math.h>
#include <iomanip>

using namespace std;

#define linha 4
#define coluna 27

int cabecalho(){

    int escolha;

    do{
        cout<< "Boas vindas ao sistema de voos da Canalhas Airlines" << endl;
        cout << "Escolha uma opcao: 1 (Fazer reserva) // 0 (Sair)" << endl;
        cin>> escolha;
    } while(escolha != 0 && escolha != 1);
    return escolha;
};

void imprime_mapa(int mapa[][coluna]){
    int i, j;
    cout << "Mapa dos voos: " << endl;
    for (i = 0; i < linha; i++){
        if (i == 0){
            cout << "A" << " ";
        } else if(i == 1){
            cout << "B" << " ";
        } else if(i == 2){
            cout << "C" << " ";
        } else {
            cout << "D" << " ";
        }
        for(j = 1; j < coluna; j++){
            cout << setw(3) << mapa[i][j];
        }
        cout << endl;
    }
};

void escolhe_assento(int mapa[][coluna], char *letra, int *fileira){
    int lin;
    do {
        cout << "Digite a letra da fileira desejada: " << endl;
        cin >> (*letra);
    } while((*letra) != 'A' && (*letra) != 'B' && (*letra) != 'C' && (*letra) != 'D');

    do {
        cout << "Digite o numero do assento desejado: " << endl;
        cin >> (*fileira) ; 
    } while(*fileira>26 || *fileira<0);

    lin = (*letra) - 65;
    
    if (mapa[lin][*fileira] == 0){ // [POSICAO]
        mapa[lin][*fileira] = 1;
    }
    else{
    cout << "Lugar já esta ocupado." << endl;
    }
};

void imprime_bilhete(char letra, int fileira){
    char nome[20];
    cout << "Bilhete impresso com sucesso!" << endl;
    cout << "Digite o nome do passageiro: " << endl;
    cin.getline(nome, 20);
    cout << endl << "Nome do passageiro: " << nome << endl;
    cout << "Dados do voo: " << endl << "Numero do voo: 675." << endl;
    cout << "Origem: Campinas."  << endl << "Destino: Rio de Janeiro." << endl;
    cout << "Assento: " << letra << fileira << endl;    
};

int main() {
    int mapa[linha][coluna]={0};
    char letra;
    int fileira;

    while(cabecalho() != 0) {
        imprime_mapa(mapa);
        escolhe_assento(mapa, &letra, &fileira);
        cout << "Reserva feita com sucesso! Verifique a marcacao do seu assento." << letra << fileira << " no mapa\n";
        imprime_mapa(mapa);
        imprime_bilhete(letra, fileira);
    }

return 0;
}