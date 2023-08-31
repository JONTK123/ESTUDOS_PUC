# Exercício 2: Encontrar a chave com o maior valor em um dicionário. Escreva uma função que recebe um dicionário como argumento e retorna a chave associada ao maior valor presente no dicionário.

def maior_valor(dicionario):
    maior = 0
    for key, values in dicionario.items():
        if values > maior:
            maior = values
    return key, maior

def criar_dicionario():
    dicionario = {}
    x = int(input('Digite o numero de vezes:'))
    for i in range(x):
        chave = input('Digite uma letra: ')
        valor = int(input(f'Digite o valor da {chave}: '))
        dicionario[chave] = valor 
    print(dicionario)
    return dicionario

resultado = maior_valor(criar_dicionario())
print(resultado)
