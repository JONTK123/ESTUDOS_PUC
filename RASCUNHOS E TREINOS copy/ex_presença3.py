'''Construa um programa que leia dois números inteiros: a e b e uma lista com N valores inteiros. O programa deverá imprimir quantos elementos pertencem ao intervalo [a;b]'''

a = int(input('Digite o valor de a: '))
b = int(input('DIgite o valor de b: '))
listan = []

while a > b:
    print('Digitou numero errado... onde o A é menor que B')       
    a = int(input('Digite o valor de a: '))
    b = int(input('DIgite o valor de b: '))

print('\nOtimo voce entrou :) ')
print('\nDigite -1 para parar o programa')

while b > a:
    
    n = int(input('Digite os valores de n: '))

    if n == -1:
        break

    elif (n < a or n > b):
            print('Elementos fora do intervalo...')

    elif(n >= a and n <= b):
        listan.append(n)
        print(listan)
       

#por algum motivo desconhecido nao funcionou

'''a = int(input('Digite o valor de a: '))
b = int(input('DIgite o valor de b: '))
listan = []
    
while True:
    n = int(input('Digite os valores de n: '))

    if (n < a or n > b):
        print('Elementos fora do intervalo...')

    else:
        listan.append(n)
        print(f'Numeros que estao dentro do intervalo {listan}')'''
    










