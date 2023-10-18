#include <iostream>
#include <cstring>

using namespace std;

#define TAM1 30
#define TAM2 20

char cabecalho() {
    char res;
    cout << "-----------------------------";
    cout << "JOGO ANAGRAMA\n Regras:\n --> Forme palavras com as letras do quadro\n --> Total de 30 palavras.\n --> Tentativas erradas encerram o jogo." << endl;
    do {
        cout << "Deseja jogar? (S/N): ";
        cin >> res;
    } while (res != 'S' && res != 'N');
    return res;
}

void imprimir_letras(char vetor_letras[]) {
    for (int i = 0; i < TAM2; i++) {
        if (i % 5 == 0) {
            cout << endl;
        }
        cout << " " << vetor_letras[i];
    }
}

int verificar_palavra(char palavra_lida[], char bancoPalavras[][15], char bancoAcertos[][15]) {
    for (int i = 0; i < TAM1; i++) {
        if (strcmp(palavra_lida, bancoPalavras[i]) == 0) {
            if (strcmp(palavra_lida, bancoAcertos[i]) == 0) {
                cout << "Palavra já encontrada." << endl;
                return 1;
            } else {
                return 0;
            }
        }
    }
    return 0;
}

void pede_palavra(char palavra_lida[]) {
    cout << "Digite uma palavra: ";
    cin.ignore();
    cin.getline(palavra_lida, 15);
}

int main() {
    int acertos = 0, erros = 0;
    char res;
    char bancoPalavras[TAM1][15] = {"Romance", "Desconto", "Banda", "Fofo", "Bala", "Torção", "Fome", "Fogo", "Medo", "Sorvete", "Banco", "Fina", "Logo", "Mão", "Rosa", "Dança", "Rato", "Boina", "Samba", "Bingo", "Bares", "Limão", "Garfo", "Ração", "Cobra", "Foca", "Faixa", "Bonito", "Barco", "Mina"};
    char bancoAcertos[TAM1][15];
    char vetor_letras[TAM2] = {'O', 'A', 'E', 'D', 'M', 'C', 'X', 'O', 'I', 'L', 'N', 'R', 'S', 'A', 'O', 'T', 'B', 'F', 'G', 'N'};
    char resp[1000];

    res = cabecalho();
    if (res == 'S') {
        cout << "Digite PARAR para encerrar o jogo." << endl;
        char resp[15];
        while (true) {
            imprimir_letras(vetor_letras);
            char palavra_lida[15];
            pede_palavra(palavra_lida);

            if (strcmp(palavra_lida, "PARAR") == 0) {
                break;
            }

            int i = verificar_palavra(palavra_lida, bancoPalavras, bancoAcertos);
            if (i == 1) {
                acertos++;
            } else {
                erros++;
                if (erros == 5) {
                    cout << "Máximo de 5 erros, encerrando o jogo..." << endl;
                    break;
                }
            }

            cout << "Deseja continuar jogando? (Digite PARAR para encerrar): ";
            cin.ignore();
            cin.getline(resp, 15);

            if (strcmp(resp, "PARAR") == 0) {
                break;
            }
        }
    }
    cout << "Pontuação: " << acertos << " acertos." << endl;
    return 0;
}
