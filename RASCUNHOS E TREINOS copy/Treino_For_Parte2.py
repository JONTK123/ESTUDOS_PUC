'''Escrever um algoritmo que leia uma quantidade desconhecida de
números e conte quantos deles estão nos seguintes intervalos:
[0.25], [26,50], [51,75] e [76,100]. A entrada de dados deve
terminar quando for lido um número negativo.'''

n = int(input('Digite um numero LIMITE a ser analizado: '))
nr1 = 0
nr2 = 0
nr3 = 0
nr4 = 0

for i in range (n): 
    n2 = int(input('Digite quantos numeros vc quiser: '))

    if n2 < 0:
        break

    if n2 > 0 and n2 <= 25:
        nr1 = n2 
        print(f'Os numeros  estao no intervalo de [0,25]')

    elif n2 > 26 and n2 <= 50:
        print(f'Os números estão no intervalo de [25,50]')

    elif n2 > 50 and n2 <= 75:
        print(f'Os númeors estão no intervalo [50,75]')

    elif n2 > 75 and n2 <= 100:
        print(f'Os números estão no intervalo [75,100]')
    
    else: print('Muito grande, desista, over haxixe sexta:')

    




