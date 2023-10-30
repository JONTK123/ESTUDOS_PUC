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

void inserir_ordenado(no* *pri) {
    no* novo, *p, *anterior; 
    elemento a;
    cout << "Digite o valor do elemento: " << endl;
    cin >> a;
    anterior=NULL; 
    novo=novo_no(); 
    novo->info=a; 

    p=*pri; 
    while (p!=NULL && a > p->info) { 
        anterior = p;
        p=p->link;
    }
    
    if(p==*pri) { 
        *pri=novo; 
    }
    else {
        anterior->link=novo;
    }

    novo->link=p; 
}

no* separar_pares(no* *pri) {
    no *p = *pri;
    no *pares_pri = init();

    while (p != NULL) {
        if (p->info % 2 == 0) {
            no *novo = novo_no();
            novo->info = p->info;
            novo->link = NULL;

            if (pares_pri == NULL) {
                pares_pri = novo;
            } else {
                pares_pri->link = novo;
                pares_pri = pares_pri->link;
            }
        }
        p = p->link;         
    }
    
    return pares_pri; 
}

no* separar_impares(no* *pri) {
    no *p = *pri;
    no *impares_pri = init(); 

    while (p != NULL) {
        if (p->info % 2 != 0) {
            no *novo = novo_no();
            novo->info = p->info;
            novo->link = NULL;

            if (impares_pri == NULL) {
                impares_pri = novo;
            } else {
                impares_pri->link = novo;
                impares_pri = impares_pri->link;
            }
        }
        p = p->link;
    }
    
    return impares_pri;
}

int main() {
    no * pri;
    int i;
    pri = init();

    for(i=0;i<5;i++){
        inserir_ordenado(&pri);
    }

    return 0;
}