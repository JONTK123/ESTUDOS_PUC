// Dada  uma  lista  ligada  contendo  números  inteiros.  Construir  uma  função  que  elimina 
// apenas o último nó. Verificar se a lista não está vazia. (ND2)

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