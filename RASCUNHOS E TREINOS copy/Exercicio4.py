'''Escreva um algoritmo que leia n de números inseridos pelo usuário (n é fornecido
pelo usuário) e realize a soma dos números pares e conta quantos ímpares o usuário
digitou. O resultado da soma dos pares e o número de ímpares digitados deverá ser
impresso no final. '''

nPares = 0
nImpares = 0

n = int(input('Digite um numero LIMITE a ser analizado: '))
for i in range (n):
    n2 = int(input('Digite os numeros a serem analizados: '))
    if n2 % 2 == 0:
        nPares += n2
    elif n2 % 3 == 0:
        nImpares += 1

print(f'A soma dos numeros pares: {nPares} e os numeros impares digitados sao {nImpares}')


