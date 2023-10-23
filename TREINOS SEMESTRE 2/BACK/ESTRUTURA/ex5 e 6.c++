#include <iostream>
#include <stdio.h>
#include <cmath>
#include <iomanip>
#include <cstdlib>

using namespace std;

// Escreva  um  programa  que  cria  uma  struct  produto  (código:  inteiro;  nome:  string; 
// preco: real; qtdd: inteira;) e cria um vetor dinâmico para N produtos (o tamanho do 
// vetor,  N,  e  os  dados  do  vetor  devem  ser  lidos).  Buscar  um  determinado  produto 
// tendo  como  entrada  o  código  e  imprimir  todos  os  dados  desse  produto.  O  código 
// do produto a ser buscado deve ser lido. O programa deve ter a seguinte divisão de 
// módulos: 

// a. Função1: ler N, alocar dinamicamente o vetor, ler as informações do vetor. 
// Comunicar as informações pela lista de parâmetros; 

// b. Função2: receber o valor de N, os valores do vetor e buscar o produto cujo 
// código  deve  ter  sido  lido  no  main  e  passado  na  lista  de  parâmetros.  A 
// posição,  dentro  do  vetor,    do  produto  buscado  deve  retornar  pelo  return. 
// Se não encontrou o produto retornar -1 pelo return. Não imprimir 
// mensagem dentro da função; 

// c. Função3: imprime os dados de UM produto.  

// d. main: declarar as variáveis do problema e chama as funções para: 
// i. alocar espaço e ler dados dos produtos; 
// ii. ler o código a ser buscado; 
// iii. buscar  o  produto  desejado,  com  o  código  lido;(chamar  a  função 
// busca_produto); 
// iv. com a posição encontrada na função anterior, imprimir os dados do 
// produto. Antes deve testar se o retorno foi -1. Isso significa que não 
// encontrou  o  produto.  Não  imprima,  na  função,  a  mensagem.  As 
// mensagens devem ficar no main

struct produto
{
    int cod;
    char nome[50];
    float preco;
    int qntd;
};

produto* ler_vetor(int *n){
    int i;
    produto *vet; // Declarei o vetor pornteiro do tipo produto pois ira apotnar para o endereco logoa abaixo

    cout << "Digite o tamanho do vetor: ";
    cin >> *n;

    vet = (produto*)malloc(*n * sizeof(produto)); 

    for (int i = 0; i < *n; i++){
        cout << "Digite o cod do produto " << i + 1 << ": ";
        cin >> vet[i].cod;
        cout << "Digite o nome do produto " << i + 1 << ": ";
        cin.ignore();
        cin.getline(vet[i].nome, sizeof(vet[i].nome));
        cout << "Digite o preco do produto " << i + 1 << ": ";
        cin >> vet[i].preco;
        cout << "Digite a qntd de produto " << i + 1 << ": ";
        cin >> vet[i].qntd;
    }


    return vet;
}

int busca_codigo(int n, produto *vet, int cod){
    
    for(int i=0;i<n;i++){
        if ( cod == vet[i].cod){
            return i;
            break;
        } else {
            return -1;
            break;
        }
    }
}

int busca_nome(int n, produto *vet, char nome[]) {
    for (int i = 0; i < n; i++) {
        if (strcmp(nome, vet[i].nome) == 0) {
            return i;
        }
    }
    return -1;  // Se nenhum produto corresponder ao nome, retorne -1
}


void imprime_produto(produto p){
    cout << "Código: " << p.cod << endl;
    cout << "Nome: " << p.nome << endl;
    cout << "Preço: " << p.preco << endl;
    cout << "Quantidade: " << p.qntd << endl;
}

void maior_menor_preco(int n, produto *vet, int &indice_maior, int &indice_menor) {
    float maior = vet[0].preco;
    float menor = vet[0].preco;
    indice_maior = 0;
    indice_menor = 0;

    for (int i = 1; i < n; i++) {
        if (vet[i].preco > maior) {
            maior = vet[i].preco;
            indice_maior = i;
        } else if (vet[i].preco < menor) {
            menor = vet[i].preco;
            indice_menor = i;
        }
    }
}

void DezPercent(int n, produto *vet){
    for (int i = 0; i < n; i++){
        vet[i].preco *= 10/100;
    }
}

int main(){
  int n, busca, cod, maior, menor, busca2;
  char nome[50];
  produto *vet;

  vet = ler_vetor(&n);

  cout << "Digite o codigo do produto: " << endl;
  cin >> cod;

  busca = busca_codigo(n,vet,cod);

  if (busca == -1){
    cout << "Nao existe produto com esse codigo.";
  } else {
    cout << "informacoes do produto " << endl;
    imprime_produto(vet[busca]); // Com o codigo buscado, ele sabera em qual posicao do vetor de struct esta as informacoes do produto come esse codigo?
  }

    maior_menor_preco(n, vet, maior, menor);

    imprime_produto(vet[maior]); 
    imprime_produto(vet[menor]); 

    cin.ignore(); // Limpar a quebra de linha no buffer

    cout << "Digite o nome do produto: " << endl;
    cin.getline(nome, 50);

    busca2 = busca_nome(n,vet,nome);

    if (busca2 == -1){
    cout << "Nao existe produto com esse nome.";
  } else {
    cout << "informacoes do produto " << endl;
    imprime_produto(vet[busca2]); // Com o codigo buscado, ele sabera em qual posicao do vetor de struct esta as informacoes do produto come esse codigo?
  }

    DezPercent(n,vet);

    for (int i = 0; i < n; i++){
        imprime_produto(vet[i]);
    }

    return 0;
}



    























