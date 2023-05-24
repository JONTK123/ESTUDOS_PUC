'''8. Elabore um programa que leia uma lista de no máximo 20 elementos inteiros. Em
seguida o programa deverá imprimir a quan#dade de valores múl#plos de 3. '''

'''qntd3 = 0

for i in range(1,21):
    l = int(input("Digite uma lista de diferentes elementos numericos ( max 20 ): "))
    if l % 3 == 0:
        qntd3 += 1

print(f'numeros que sao multiplos de 3: {qntd3}')'''    

l = 1
ListaQNTD3 = [l]
qntd3 = 0

for i in range(1,21): 

    ListaQNTD3.append(int(input("Digite uma lista de diferentes elementos numericos ( max 20 ): ")))

    print(l)



    if i % 3 == 0:
        qntd3 += 1

print(f'numeros que sao multiplos de 3: {qntd3}')

print(ListaQNTD3)
