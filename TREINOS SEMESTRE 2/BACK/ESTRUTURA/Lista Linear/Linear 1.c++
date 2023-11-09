#include <iostream>
#include <"lista_cf.h">
 
typedef int elemento_lista;
#include “lista_cf.h”

using namespace std;

void ler_lista(Lista& L) {
    int v;
    for (int i = 1; i < 5; i++) { // Dou um tamanho qualquer para a lista, ou definir com um N // Começa com 1.
        cout << "Digite um número para inserir na lista: ";
        cin >> v;
        inserir(L, v, i);
    }
}

void imprimir_lista(const Lista& L) { // Recebe endereço no parametro
    int c = compr(L); // Puxa o valor 5 definida na função passada
    for (int i = 1; i <= c; i++) {
        int valor = consultar(L, i); //Nao pode usar diretamente o INDICE i, pois estamos tratando com SEQUENCIA e nao o INDICE de um array em si.
        cout << valor << " ";
    }
    cout << endl;
}

int main() {
    Lista L;
    init(L);

    ler_lista(L);
    imprimir_lista(L); // Passagem de referencia, basicamente estamos tratando com ponteiros e dnederços mas c++ eh evoluido e nos permitiu trabalhar com isso apenas colocando  um &nos parametros

    return 0;
}
