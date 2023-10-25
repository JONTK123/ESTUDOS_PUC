//Dada uma lista ligada contendo números inteiros ordenados. Construir uma função
//que verifica se há algum número repetido na lista ou não. Caso exista alguma
//repetição retornar 1 senão retornar 0. Não usar estruturas auxiliares para a solução,
//tais como, vetor ou outra lista ligada.

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

no* novo_no (){
    no* novo;
    novo = (no*) malloc(sizeof(no));
    if(novo == NULL) {
       cout<<"\n ERRO: alocacao de memoria!" ;
       exit(1);}
    return novo;
}

void inserir_ordenado(no* *pri, elemento a) {
    no* novo, *p, *anterior; // inicializa 3 ponteiros de inteiro
    anterior=NULL; // anterior é inicializada como NULL, pois na primeira inserçao só tem 1 numero na lista, entao, nenhum anterior
    novo=novo_no(); // atribui a "novo" a struct padrão para nós
    novo->info=a; // atribui valor para o elemento atual da lista

    p=*pri; // declara que p aponta para o início da lista
    while (p!=NULL && a > p->info) { // enquanto a lista não acabar E enquanto a info q entrar for maior q a próxima(inicializa NULL)
        anterior = p; // anterior passa a ser o elemento de análise atual
        p=p->link; // o elemento de análise atual se torna o próximo elemento da lista
    }
    
    if(p==*pri) { // se o elemento de análise atual for igual ao primeiro
        *pri=novo; // o primeiro elemento passa a apontar par ao novo elemento
    }
    else {
        anterior->link=novo;// quando a não for maior que o proximo, o loop irá parar. entao, o link do anterior receberá o novo elemento
    }
    novo->link=p; // de qualquer maneira, o link do novo elemento recebe o elemento atual
}

int verifica(no* pri) {
    no *p = pri;
    while(p!=NULL) {
        no *q = p->link;
        cout << p->info << endl;

        while(q!=NULL) {
            if(p->info==q->info) {
                return 1;
            }
            q=q->link;
        }
        p=p->link;

    }
    return 0;
}
   

int main() {
    no * pri;
    pri = init();

    inserir_ordenado(&pri, 5);
    inserir_ordenado(&pri, 3);
    inserir_ordenado(&pri, 1);
    inserir_ordenado(&pri, 4);
    inserir_ordenado(&pri, 2);

    
    int num=verifica(pri);

    if(num==1) {
        cout << "Existem elementos repetidos";
    }
    else {
        cout << "Não existem elementos repetidos";
    }


    return 0;
}