// Sobre Inserções na lista: 
// 1. Dada  uma  lista  ligada  contendo  números  inteiros.  Construir  uma  função  que  insere 
// uma nova informação V após o nó que possui a informação armazenada em X. Supor X 
// e  V  valores  lidos  na  main  e  passados  na  lista  de  parâmetros.  Não  usar  estruturas 
// auxiliares para a solução, tais como, vetor ou outra lista ligada. (ND 2)

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

void inserir_info(no**pri, elemento x, elemento v){
    no *p = *pri;
    no *novo = novo_no();


    while (p != NULL){
        if(p->info == x){
            novo->info=v;
            novo->link = p->link;
            p->link=novo;
            break;
        }
    }
    p = p->link;
}

int main() {
    no * pri;
    pri = init();
    int x = 5;
    int v = 10;

    for(int i = 0;i<5;i++){
        inserir_inicio(&pri);
    }

    inserir_info(&pri, x, v);

    return 0;
}