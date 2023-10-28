// Dada  uma  lista  ligada  contendo  números  inteiros.  Construir  uma  função  que  elimina 
// apenas o último nó. Verificar se a lista não está vazia. (ND2)

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

void inserir_inicio(no**pri){ // Recebe o ponteiro do ponteiro de pri, que aponta para o primeiro ponteiro. Usaremos ele para udar seu valor sem mudar seu endereço definitivo 

    no*novo=novo_no(); // criação de um novo nó

    cout << "Digite o valor do elemento: "; // Elemento que será inserido no nó
    cin >>novo->info; // Aloca para o campo info da estrutura nó

    novo->link=*pri; // Aponta ponteiro link para o poteiro de *pri. Ponteiro de pri carrega as informações do primeiro nó
    *pri = novo; // Agora o NOVO nó se torna o primeiro para continuar as ligações
}

void elimina_no(no **pri){
    no *p;
    p = *pri;
    no *anterior;

    if (p == NULL ){
        cout << "Lista está vazia";
        return;
    }

    while (p != NULL) {
        if (p -> link == NULL){
        anterior = p;
        p = p->link;
        }
    }

    anterior->link = NULL;  

}

int main() {
    no * pri;
    pri = init();

    for(int i = 0;i<5;i++){
        inserir_inicio(&pri);
    }

    elimina_no(&pri);

    return 0;
}