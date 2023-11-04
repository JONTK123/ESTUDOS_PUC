#include <iostream>

using namespace std;

//Dada uma lista ligada. Construir uma função que conta o número de nós dessa lista. O
//número de nós encontrado deverá retornar pelo comando return. (ND 1)

typedef int elemento; //Tipo INT elemento, apenas outro nome
typedef struct no { //Criação Struct Nó
    elemento info; //Variável "info" será usada para armazenar o dado associado a cada nó da lista ligada
    no * link; //Variavel ponteiro do tipo no chamada de link. 
    }no;

no* init(){
    return NULL;
}

no* novo_no (){ // Criação de um novo nó
    no* novo; // Criaçãod e uma variavel ponteiro do tipo nó
    novo = (no*) malloc(sizeof(no)); // Aloca dinamicamente na memória o tamanho como o tamanho do nó ( struct )
    if(novo == NULL) { // Validação
       cout<<"\n ERRO: alocacao de memoria!" ;
       exit(1);
       }
    return novo;
}

int comp(no*pri){
    int conta;
    for(conta=0;pri!=NULL;pri=pri->link) conta++; // Pri = pri -> link ( isso faz com que avance para o proximo no )
    // Se em cada posicção da lista ligada, tivermos um nó, acrescenta para um contador indicando o tamanho da lista
    return conta;
}

void inserir_inicio(no**pri){ // Recebe o ponteiro do ponteiro de pri, que aponta para o primeiro ponteiro. Usaremos ele para udar seu valor sem mudar seu endereço definitivo 

    no*novo=novo_no(); // criação de um novo nó

    cout << "Digite o valor do elemento: "; // Elemento que será inserido no nó
    cin >>novo->info; // Aloca para o campo info da estrutura nó

    novo->link=*pri; // Aponta ponteiro link para o poteiro de *pri. Ponteiro de pri carrega as informações do primeiro nó
    *pri = novo; // Agora o NOVO nó se torna o primeiro para continuar as ligações
}
                                          
int main() {
    int i; // Index para o FOR
    no *pri; // Primeiro Nó da lista
    pri = init(); // Inicia o Nó vazio
    for(i=0;i<4;i++){ // Coloca 4 nós na lista
        inserir_inicio(&pri); // Enviamos o endereço do ponteiro de pri, para mudarmos o seu valor sem dar para ele um endereço definitivo
    }
    int conta=comp(pri); // Retorna o tamanho da lista ligada.
    cout << "Total de numeros: " << conta;

    
    return 0;
    }
