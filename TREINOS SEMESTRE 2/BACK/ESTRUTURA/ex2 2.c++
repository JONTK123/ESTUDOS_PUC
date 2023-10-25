#include <iostream>

using namespace std;

// Dada  uma  lista  ligada  contendo  números  inteiros  ordenados.  Construir  uma  função 
// que verifica se há algum número repetido na lista ou não. Caso exista alguma 
// repetição  retornar  1  senão  retornar  0.  Não  usar  estruturas  auxiliares  para  a  solução, 
// tais como, vetor ou outra lista ligada. 

typedef int elemento; 
typedef struct no { 
    elemento info; 
    no * link; 
    }no;

no *init() {
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



void insere_ordenado(no **pri, elemento x) {
    no *anterior;
    no *p; //Variavel para percorrer a lista ligada JA EXISTENTE
    no *novo = novo_no();
    novo->info=x; 








}

int verifica_repetidos(){




    return 1;


    return 0;
}


int main() {
    no *pri;
    pri = init();

    insere_ordenado(&pri, 5);



    
    return 0;
    }
