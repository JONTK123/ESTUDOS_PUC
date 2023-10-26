// Sobre Inserções na lista: 
// 1. Dada  uma  lista  ligada  contendo  números  inteiros.  Construir  uma  função  que  insere 
// uma nova informação V após o nó que possui a informação armazenada em X. Supor X 
// e  V  valores  lidos  na  main  e  passados  na  lista  de  parâmetros.  Não  usar  estruturas 
// auxiliares para a solução, tais como, vetor ou outra lista ligada. (ND 2)

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