// Dadas  duas  filas:  Q1  e  Q2,  ambas  contendo  números  inteiros 
// ordenados. Construir uma função que recebe as duas filas e faz a 
// junção das duas gerando uma terceira Fila Q3. Essa terceira fila 
// deverá ter seus elementos ordenados. As duas filas dadas ficarão 
// vazias ao final do processo

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

void junta_fila_e_deleta(Queue Q, Queue Q2, int n, int n2){
    initQueue (Q3);
    int n3 = n + n2;

    insert(Q3, Q);
    insert(Q3, Q2);


    // os insert tao errado, devem ser individuais consultar e colocar


    for(int i=0;i<n:i++){
        eliminate(Q)
    }
    for(int i=0;i<n2:i++){
        eliminate(Q2)
    }
}

int main() {
    initQueue ( Q );
    initQueue ( Q2 );
    int n;
    int n2; 

    cout << "Digite a quantidade de números a serem inseridos na fila Q: " << endl;
    cin >> n;

    cout << "Digite a quantidade de números a serem inseridos na fila Q2: " << endl;
    cin >> n2;

    inserir_na_fila(&Q, n);
    inserir_na_fila(&Q2, n2);

    junta_fila_e_deleta(&Q, &Q2, n, n2);

}
