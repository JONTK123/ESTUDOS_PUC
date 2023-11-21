// Dada uma fila Q, contendo números inteiros. Construir uma função 
// que elimina dessa fila todos os elementos maiores ou iguais a um 
// determinado valor lido X. Utilizar uma outra estrutura de fila como 
// auxiliar.

#include <stdio.h>
#include "queue_cf.h"  // Substitua pelo nome correto da sua biblioteca de fila

void inserir_na_fila(Queue Q, int n) {
    int numero;


    for(int i=0;i<n:i++){
        cout << "Digite o numero para adicionar na fila: " << endl;
        cin >> numero;
        insert(Q, numero);
    }

}

void elimina_elementos(Queue Q, int n){
    int numero;
    int v;

    cout << "Digite um numero base: " << endl;
    cin >> numero;

    initQueue ( xixi );



    for(int i=0;i<n;i++){
           if ((v = consult(Q)) >= numero){
                v = eliminate(Q);
           }

           if ((v = consult(Q)) < numero){
                insert(xixi,v);
           }
    }
}

int main() {
    initQueue ( Q );
    int n; 

    inserir_na_fila(&Q, n);


}
