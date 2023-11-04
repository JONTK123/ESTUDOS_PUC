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
    elemento a;
    int b=1,c=1;
    a=1;

    for(int i=0;i<10;i++){ //10 nos na lista ligada
        a = ((b+=2)/c++);
        novo = novo_no();
        novo->info = a;
        novo->link = *pri;
        *pri = novo;
    }
}

int main() {
    no * pri;
    pri = init();

    criar_lista(&pri);

    return 0;
}