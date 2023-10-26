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

void contar_lista(no**pri){
    no *p;
    no *novo;
    int contador1=0;
    int contador2=0;
    int contador3=0;
    int contador4=0;
    int contador5=0;
    int contador6=0;
    int contador7=0;
    int contador8=0;
    int contador9=0;
    int contador10=0;

    p = *pri;
    while(p != NULL){
        if (p->info == 1){
            contador1++;
        }
        if (p->info == 2){
            contador2++;
        }
        if (p->info == 3){
            contador3++;
        }
        if (p->info == 4){
            contador4++;
        }
        if (p->info == 5){
            contador5++;
        }
        if (p->info == 6){
            contador6++;
        }
        if (p->info == 7){
            contador7++;
        }
        if (p->info == 8){
            contador8++;
        }
        if (p->info == 9){
            contador9++;
        }
        if (p->info == 10){
            contador10++;
        }

        p=p->link???
    }

        novo = novo_no();
        novo->info=contador1;
        novo->link=*pri;
        *pri=novo;

        novo = novo_no();
        novo->info=contador2;
        novo->link=*pri;
        *pri=novo;

        novo = novo_no();
        novo->info=contador3;
        novo->link=*pri;
        *pri=novo;

        novo = novo_no();
        novo->info=contador4;
        novo->link=*pri;
        *pri=novo;

        novo = novo_no();
        novo->info=contador5;
        novo->link=*pri;
        *pri=novo;

        novo = novo_no();
        novo->info=contador6;
        novo->link=*pri;
        *pri=novo;

        novo = novo_no();
        novo->info=contador7;
        novo->link=*pri;
        *pri=novo;

        novo = novo_no();
        novo->info=contador8;
        novo->link=*pri;
        *pri=novo;

        novo = novo_no();
        novo->info=contador9;
        novo->link=*pri;
        *pri=novo;

        novo = novo_no();
        novo->info=contador10;
        novo->link=*pri;
        *pri=novo;
}

int main() {
    no * pri;
    pri = init();

    contar_lista(&pri);

    return 0;
}
