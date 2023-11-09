#include <iostream>
#include <"lista_cf.h">
 
typedef int elemento_lista;
#include “lista_cf.h”

using namespace std;

// Dadas duas listas linear L1 e L2, contendo elementos quaisquer. Supor que 
// a primeira lista comporta ambas. Construir uma função que acrescenta a lista 
// L2 no final da L1

void ler_lista(Lista& L) {
    int v;
    for (int i = 1; i <= 5; i++) { // Dou um tamanho qualquer para a lista, ou definir com um N // Começa com 1.
        cout << "Digite um número para inserir na lista: ";
        cin >> v;
        inserir(L, v, i);
    }
}

void inseir_lista(Lista& L1, Lista& L2){
    int v;
    c1 = compr(L1);
    c2 = compr(L2);
    for (int i = 1; i <= c2; i++) { 
        v = consultar(L2,i);
        inserir ( L1,V, c1 + i); // c1 + i para indicar que sera depois de todo o COMPRIMENTO, ao final
    }

}

int main() {
    Lista L1;
    init(L1);

    Lista L2;
    init(L2);

    ler_lista(L1);
    ler_lista(L2);

    inseir_lista(L1, L2);



    return 0;
}
