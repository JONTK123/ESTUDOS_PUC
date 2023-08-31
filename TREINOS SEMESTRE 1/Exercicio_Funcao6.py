def criarLista():
    
    x = int(input('Digite um valor para x: ')) # Leio um numero inteiro
    x_str = str(x) # transformo em str para percorrer CADA elemento digitado
    lista = []
    for i in  (x_str): # percorro cada elemento digitado
        lista.append(int(i)) # Coloco cada item percorrido em formato de inteiro novamente para poder realizar a soma
    print(lista)

    return lista # retornar listas pois esse valor ( valor da funcao criarLista ) sera usado dps


def somaDigitos(lista):

    soma = 0
    
    for i in (lista):
        soma += i

    return soma

def maiorDigito(lista):
    
    maior = 0

    for i in (lista):
        if i > maior:
            maior = i

    return maior

# METODO SEM CRIAR UMA FUNCAO PARA CRIAR LISTA

'''x = int(input('Digite um valor para x: ')) # Leio um numero inteiro
x_str = str(x) # transformo em str para percorrer CADA elemento digitado
lista = []
for i in  (x_str): # percorro cada elemento digitado
    lista.append(int(i)) # Coloco cada item percorrido em formato de inteiro novamente para poder realizar a soma
print(lista)'''

# METODO CRIANDO UMA FUNCAO PARA CRIAR LISTA

lista = criarLista()
calcularSoma = somaDigitos(lista)
definirMaior = maiorDigito(lista)

print(calcularSoma, definirMaior)