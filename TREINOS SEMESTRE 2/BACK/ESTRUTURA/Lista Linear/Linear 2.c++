#include <iostream>
#include <"lista_cf.h">
 
typedef int elemento_lista;
#include “lista_cf.h”

using namespace std;

// Construir uma função que recebe uma lista linear L, com números inteiros,
// e verifica se os elementos da lista estão em ordem crescente. O resultado
// deverá retornar através de um return. Na main, imprimir mensagem.


void ler_lista(Lista& L) {
    int v;
    for (int i = 1; i <= 5; i++) { // Dou um tamanho qualquer para a lista, ou definir com um N // Começa com 1.
        cout << "Digite um número para inserir na lista: ";
        cin >> v;
        inserir(L, v, i);
    }
}

int verificar_lista(Lista& L){
    int res;
    int v;

    int c = compr(L);
        for (int i = 1; i <= c; i++) { 
            if(consultar(L,i) < consultar(L,i+1)){
                res = 1
                break;
            } else {
                res = 0
                break;
            }
        }
    return res;
}
int main() {
    Lista L;
    int resultado;
    init(L);

    ler_lista(L);

    resultado = verificar_lista(L);

    if (resultado == 1){
        cout <<"Ordem crescente.";
    } else {
        cout <<"Ordem decresecente.";
    }

    return 0;
}
