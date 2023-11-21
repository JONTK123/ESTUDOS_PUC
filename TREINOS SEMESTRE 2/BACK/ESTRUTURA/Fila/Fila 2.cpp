// Dada uma fila Q qualquer. Construir uma função que elimina dessa 
// fila os N primeiros elementos. Prever a possibilidade de a fila estar 
// vazia e de não ter N elemento

#include <stdio.h>
#include "queue_cf.h"  // Substitua pelo nome correto da sua biblioteca de fila

// Função para ler n números inteiros e inseri-los em uma fila
void inserir_na_fila(Queue Q, int n) {
    int numero;


    for(int i=0;i<n:i++){
        cout << "Digite o numero para adicionar na fila: " << endl;
        cin >> numero;
        insert(Q, numero);
    }

}

void remover_n_elementos(Queue *Q, int n) {
    int v;
    int numero;

    cout<<"Digite a quanitdade de numeros que deseja elminar: " << endl;
    cin >> numero;

    if (Q != NULL && numero > 0) { // PRIMEIRO INICIALIZAMOS A LISTA E DEPOIS DEFINIMOS UM TAMANHO A ELA
        for (int i = 0; i < n; i++) {
            if (!isEmptyQ(Q)) { // PODE SER QUE OS VALORES ESTEJAM VAZIOS E O TAMANHO SEJA NEGATIVO MESMO ASSIM
                eliminate(Q); // ELIMINANDO OS ELEMNTOS A FRENTE DA PILHA, OU SEJA OS PRIMEIROS QUE ENTRARAM. QUANTOS? A QUANTIDADE DE VZES DEFINIDA NA VARIAVEL NUMERO
            } else {
                printf("A fila está vazia.\n");
                break;
            }
        }
    }
}

int main() {
    initQueue ( Q )
    int n; //tamanho da fila
    inserir_na_fila(&Q, n);

    remover_n_elementos(&Q, n);
}
