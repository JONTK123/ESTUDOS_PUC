// Dada uma lista ligada contendo números inteiros (entre1 e 10 ), não ordenados, e que 
// há várias repetições de cada um eles. Construir uma função que cria uma segunda lista 
// ligada  para  conter:  no  1°  nó  a  quantidade  de  repetições  do  número  1,  no  2°  nó  as 
// repetições do número 2, e assim por diante, até o 10° nó. (ND 3)

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

int *contar_lista(no** pri){

    int* contador = (int*) malloc(10 * sizeof(int)); 
    // int contador[10] = {0};     
    no *p = *pri;

    while(p != NULL){
        if(p->info >= 0 && p->info <= 9){ 
            contador[p->info]++; 
        }
        p = p->link; 
    }
    return contador; 
}

void nova_lista(no**pri, int a){

    no*novo=novo_no();
    novo->info=a;
    novo->link=*pri;
    *pri = novo;
}


int main() {
    no * pri;
    int *a;
    pri = init();

    a = contar_lista(&pri);

    for (int i=0;i<+9;i++){
        nova_lista(&pri, a[i]);
    }

    free(a); 

    return 0;
}
