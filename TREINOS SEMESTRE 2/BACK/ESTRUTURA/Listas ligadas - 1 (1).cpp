//Dada uma lista ligada. Construir uma função que conta o número de nós dessa lista. O
//número de nós encontrado deverá retornar pelo comando return. (ND 1)

#include <iostream>
using namespace std;

typedef int elemento;
typedef struct no {
    elemento info;
    no * link;
    }no;

no * init() {
    return NULL;
}

no* novo_no (){
    no* novo;
    novo = (no*) malloc(sizeof(no));
    if(novo == NULL) {
       cout<<"\n ERRO: alocacao de memoria!" ;
       exit(1);}
    return novo;
}

void inserir_inicio(no**pri){

    no*novo=novo_no();
    cout << "Digite o valor do elemento: ";
    cin >> novo->info;
    novo->link=*pri;
    *pri = novo;
}
    
int comp(no*pri){
    int conta;
    for(conta=0;pri!=NULL;pri=pri->link) {
        conta++;
        cout << pri->info << endl;
    }
    return conta;
}
int main() {
    int i;
    no * pri;
    pri=init();
    for(i=0;i<4;i++) {
        inserir_inicio(&pri);
    }
    int conta=comp(pri);
    cout << "Total de numeros: " << conta;

    
    return 0;
    }
