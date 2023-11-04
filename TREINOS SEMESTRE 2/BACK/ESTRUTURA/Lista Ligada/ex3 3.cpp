// Construir  uma  função  que  cria  uma  lista  ligada  para  conter  em  cada  nó  um  número 
// inteiro  com  a  seguinte  regra:  o  1º  elemento  deverá  ser  igual  a  1,  o  2º  é  igual  ao 
// primeiro*2,  o  3º  igual  ao  segundo  *2,  e  assim  por  diante.  Parar  quando  o  cálculo  do 
// elemento for maior do que 1000. Não inserir o resultado maior do que 1000. (ND 3)

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

void criar_lista(no **pri){
    no* novo;
    elemento a;
    a = 1;

    while(1000){
        novo = novo_no();
        novo->info = a;
        novo->link = *pri;
        *pri = novo;
        a *= 2;
    }
}

int main() {
    no * pri;
    pri = init();

    criar_lista(&pri);

    return 0;
}