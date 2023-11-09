#include <iostream>
#include <"lista_cf.h">
 
typedef int elemento_lista;
#include “lista_cf.h”

using namespace std;

// Dada uma lista linear L, contendo números inteiros quaisquer. Construir uma 
// função que elimina dessa lista o maior elemento.

void ler_lista(Lista& L) {
    int v;
    for (int i = 1; i <= 5; i++) { // Dou um tamanho qualquer para a lista, ou definir com um N // Começa com 1.
        cout << "Digite um número para inserir na lista: ";
        cin >> v;
        inserir(L, v, i);
    }
}

void elimina_ultimo(Lista& L){
    int v;
    int maior = consultar(L, 1); // Valor do primeiro elemento = maior
    int posicao_maior = 1; // Posicao do primeiro elemnto = maior
    c = compr(L);

    for(int i=2;i<=c;i++){ // Começa pelo segundo elemento da lista pois o primeiro eh o maior ja, MAS se o seugndo for maior q o primeiro

        if(consultar ( L, i ) > maior ){ //Compara os valores
            maior = consultar ( L, i); //Salva o valor
            int posicao_maior = i; //Salva sua posição, index

        }
    }
        eliminar(L, posicao_maior) // A eliminação se da pela posição, nao valor.

}

int main() {
    Lista L1;
    init(L1);
 

    return 0;
}
