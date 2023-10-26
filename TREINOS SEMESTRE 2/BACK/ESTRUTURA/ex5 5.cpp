// Construir uma função que cria uma lista ligada para conter em cada nó um termo da 
// seguinte soma: (ND 3) 

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

void criar_lista(no**pri){
    no* novo;
    no* p;
    novo = novo_no();
    elemento a;
    int b=1,c=1;

    a = ((b+=2)/c++);

    p=*pri;
    while(p!=NULL){
        novo = novo_no();
        novo->info = a;
        novo->link=*pri; 
    }
}

int main() {
    no * pri;
    pri = init();

    return 0;
}