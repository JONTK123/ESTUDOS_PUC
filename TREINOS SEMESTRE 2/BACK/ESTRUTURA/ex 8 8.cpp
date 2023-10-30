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
    no *pares = init(); // Inicializa a lista de pares como vazia
    no *pares_head = pares; // Cabeça da lista de pares

    while (p != NULL) {
        if (p->info % 2 == 0) {
            no *novo = novo_no();
            novo->info = p->info;
            novo->link = NULL;

            if (pares == NULL) {
                pares = novo;
                pares_head = pares;
            } else {
                pares->link = novo;
                pares = pares->link;
            }
        }
        p = p->link;         
    }
    
    return pares_head; // Retorna a cabeça da lista de pares
}

// Função para separar números ímpares em uma lista ligada separada
no* separar_impares(no* *pri) {
    no *p = *pri;
    no *impares = init(); // Inicializa a lista de ímpares como vazia
    no *impares_head = impares; // Cabeça da lista de ímpares

    while (p != NULL) {
        if (p->info % 2 != 0) {
            no *novo = novo_no();
            novo->info = p->info;
            novo->link = NULL;

            if (impares == NULL) {
                impares = novo;
                impares_head = impares;
            } else {
                impares->link = novo;
                impares = impares->link;
            }
        }
        p = p->link;
    }
    
    return impares_head; // Retorna a cabeça da lista de ímpares
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