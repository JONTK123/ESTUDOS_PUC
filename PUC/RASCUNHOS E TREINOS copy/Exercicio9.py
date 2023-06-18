'''. Elabore um programa que leia um conjunto de vários valores inteiros e os coloque
em 2 listas conforme forem pares ou ímpares (uma lista para números pares e outra
lista para números ímpares). A leitura dos números é finalizada quando um número
nega#vo é lido.'''

# COMANDO .APPEND PARA ACRESCENTAR A LISTA

p = 0

ListaPar = [p]
ListaImpar = [p]

n = int(input('Digite um numero N limite para analizar: '))

for u in range(n):

    p = int(input('Digite alguns numeros para analizar se é PAR OU IMPAR: '))

    if p == -1:  
        break

    if p % 2 == 0:
        ListaPar.append(p)

    elif p % 2 != 0:
        ListaImpar.append(p)

#NAO SEI ELIMINAR O ENDEREÇO INICIAL E DEIXA-LO VAZIO PARA NAO MOSTRAR 0 NO PRINT SEMPRE

#EH SO COLOCAR UM SLICE NO PRINT

print('Par:', ListaPar[1:])
print('Impar', ListaImpar[1:])

