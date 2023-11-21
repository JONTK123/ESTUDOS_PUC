// Construir uma função que faz a leitura de n números inteiros para 
// uma fila

#include <stdio.h>
#include "queue_cf.h"  // Substitua pelo nome correto da sua biblioteca de fila

// Função para ler n números inteiros e inseri-los em uma fila
void lerNumerosNaFila(Queue *Q, int n) {
    int numero;

    printf("Digite %d números inteiros:\n", n); //Qunaitdade de inserções

    for (int i = 0; i < n; ++i) {
        printf("Número %d: ", i + 1);
        scanf("%d", &numero);

        // Insere o número na fila
        insert(Q, numero);
    }
}

int main() {
    initQueue ( Q )
    int n;

    printf("Digite a quantidade de números a serem lidos: ");
    scanf("%d", &n); //Quantidade de numeros na fila

    lerNumerosNaFila(&Q, n);

    return 0;
}
