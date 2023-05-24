'''1. Elabore um programa que imprima os resultados da tabuada de um número inserido
pelo usuário. '''

n = int(input('Digite um numero para mostrar a tabuada: '))

for k in range (1,11):
    num = k * n
    print (f'{n} * {k} = {num}')
