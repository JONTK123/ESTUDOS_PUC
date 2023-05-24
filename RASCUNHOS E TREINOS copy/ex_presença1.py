#Elabore um programa que leia uma lista de no máximo 10 elementos reais, o programa deverá imprimir o maior e segundo maior elemento e suas respectivas posições na lista


listax = []
'''lista1 = [] # maior
lista2 = [] # segundo maior
maior = 0
menor = 0

for i in range(11):
    listax.append(int(input('Digite o valor de x: ')))

for j in range(len(listax)):
       
    if listax[j] > listax[j-1]:
        maior = listax[j]
        lista1.append(maior)

    if listax[i] < menor:
        menor = listax[i]
        lista2.append(menor)

print(f'lista maior: {lista1}')
print(f'lista menor: {menor}')'''

# NAO SEI FAZER SEM AS FUNÇÕES DA FUNÇÃO PROF

for i in range(11):
    listax.append(int(input('Digite o valor de x: ')))

    listax.sort()
    listax.reverse()

print(f'A lista dos numeros é; {listax}')
print(f'O numero maior é {listax[0]} e o segundo numero maior é {listax[1]}' )


    

