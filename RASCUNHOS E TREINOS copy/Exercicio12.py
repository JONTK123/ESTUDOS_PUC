'''Faça um Programa que peça as duas notas de 10 alunos, calcule e armazene numa
lista a média de cada aluno, imprima o número de alunos com média maior ou igual
a 7.0. '''

# VOU FAZER COM APENAS UMA NOTA PQ NAO SEI SUBLISTA

listanotas = []
listamedia= []
media = 0
j = 0
nota = 0
i = 0

'''for i in range (0,10):

    listanotas.append(int(input('Digite a nota dos 10 alunos: ')))

    print(i)

    while listanotas[i] > 10:
        i -= 1
        listanotas.append(int(input('Digite a nota dos 10 alunos, que seja menor que <= 10: ')))
        print(i)

    media = sum(listanotas) / len(listanotas)

    j += 1

print(f'media: {media:.2f} ')
print(f'Quantidade de alunos com media > 7: {j:.2f}')'''

while True:

    nota = int(input('Digite o valor da nota: '))

    if nota <= 10:
    
        nota2 = int(input('Digite o valor da nota2: '))
        while nota2 > 10:
            nota2 = int(input('Digite o valor correto da nota2: '))

    else: 
        
        while nota > 10:
            nota = int(input('Digite o valor correto da nota: '))

    i += 1

    media = (nota + nota2) / 2

    if media > 7:
        j += 1

    if i == 10:
        break

    listamedia.append(media)

print(f'media: {listamedia} ')
print(f'Quantidade de alunos com media > 7: {j}')

   






   






