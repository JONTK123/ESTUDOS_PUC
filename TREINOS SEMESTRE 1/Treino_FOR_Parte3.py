'''Escreva um algoritmo que leia n de números inseridos pelo
usuário (n é fornecido pelo usuário) e realize a soma dos números
pares e conta quantos impares o usuário digitou. O resultado da
soma dos pares e o número de ímpares digitados deverá ser
impresso no final'''

'''countImpar = 0
n = 1
nPares = 0

print('Para parar tecle 0...')

while n != 0:
    n = int(input('Digite valores impares e pares sem ordem definida e aleatoriamente para a variavel n: '))
    if n % 2 == 0:
        nPares += n

    elif n % 2 != 0:
        countImpar += 1

print(f'A soma dos numeros pares: {nPares} e os numeros impares digitados sao {countImpar}')'''

n = int(input('Digite um numero LIMITE a ser analizado: '))
npares = 0
nimpar = 0
for i in range (n):
    n2 = int(input('Digite os numeros a serem analizados como impares e pares:'))
    if n2 % 2 ==0:
        npares += n2
    else:
        nimpar += 1
print(f'A soma dos numeros pares: {npares} e os numeros impares digitados sao {nimpar}')
