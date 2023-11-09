#include <iostream>
#include <"lista_cf.h">
 
typedef int elemento_lista;
#include “lista_cf.h”

using namespace std;

// Dadas  duas  listas linear L1  e  L2,  ambas  contendo  números  inteiros 
// ordenados.  Construir  uma  função  que  cria  uma  terceira  lista  linear  L3 
// contendo os elementos da interseção de L1 com L2

void ler_lista(Lista& L) {
    int v;
    for (int i = 1; i <= 5; i++) { // Dou um tamanho qualquer para a lista, ou definir com um N // Começa com 1.
        cout << "Digite um número para inserir na lista: ";
        cin >> v;
        inserir(L, v, i);
    }
}

void inserir_lista(Lista& L1, Lista& L2, Lista& L3){
    int v;
    c1 = compr(L1);
    c2 = compr(L2);
    for (int i = 1; i <= c2; i++) { 
        v = consultar(L2,i);
        inserir ( L1,v, c1 + i); // c1 + i para indicar que sera depois de todo o COMPRIMENTO, ao final
    }

    c3 = compr(L1); //Apos atribuir novos valores a L1, definir o tamanho da nova lista com a NOVA lista L1.

    for (int i = 1; i <= c3; i++) { 
        v = consultar(L1,i);
        inserir(L3,v,i);
    }

}

int main() {
    Lista L1, L2, L3;
    init(L1);
    init(L2);
    init(L3);

    ler_lista(L1);
    ler_lista(L2);

    inserir_lista(L1, L2, L3);

    return 0;
}
