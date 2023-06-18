'''Elabore um programa que leia um número e imprima todos os
números divisíveis por 4 que sejam menores que este número lido'''

n = int(input('Digite o numero:'))
nDiv4 = 0

for k in range (n): #como quer todos os div por 4 menore q esse numero, mantem o range assim.
    if k % 4 == 0:
        nDiv4 = k
        print(f'Numeros que sao divisiveis por 4 sao: {nDiv4}')
