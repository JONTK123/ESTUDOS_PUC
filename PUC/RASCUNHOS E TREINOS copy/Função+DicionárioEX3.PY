# Exercício 3: Mesclar dois dicionários.
# Escreva uma função que recebe dois dicionários como argumentos e retorna um novo dicionário que é a mescla dos dois dicionários fornecidos.

def mesclar_dicionario(dicionario1,dicionario2):
    dicionario1.update(dicionario2)
    return dicionario1

def criar_dicionario1():
    dicionario1 = {}
    x = int(input('Digite o numero de vezes:'))
    for i in range(x):
        chave = input('Digite uma letra: ')
        valor = int(input(f'Digite o valor da {chave}: '))
        dicionario1[chave] = valor 
    print(dicionario1)
    return dicionario1

def criar_dicionario2():
    dicionario2 = {}
    x = int(input('Digite o numero de vezes:'))
    for i in range(x):
        chave = input('Digite uma letra: ')
        valor = int(input(f'Digite o valor da {chave}: '))
        dicionario2[chave] = valor 
    print(dicionario2)
    return dicionario2

resultado = mesclar_dicionario(criar_dicionario1(),criar_dicionario2())
print(resultado)

