// Dada  uma  lista  ligada  contendo  números  inteiros  ordenados.  Construir  uma  função 
// que separa os elementos da lista ligada ordenada em duas. A original fica com os pares 
// e a nova com os ímpares. (ND3)

#include <iostream>
using namespace std;

typedef int elemento;
typedef struct no {
    elemento info;
    no *link;
}no;

no *init() {
    return NULL;
}

no *novo_no (){
    no* novo;
    novo = (no*) malloc(sizeof(no));
    if(novo == NULL) {
       cout<<"\n ERRO: alocacao de memoria!" ;
       exit(1);}
    return novo;
}

int main() {
    no * pri;
    pri = init();

    return 0;
}