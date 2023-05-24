'''Faça um Programa que leia uma lista de 10 números inteiros, mostre a soma, a
multiplicação e os números. '''

# COMANDO SUM PARA SOMAR ELEMENTOS DENTRO DE UMA LISTA

# Import math math.prod resolveria todos os problemas

soma = 0
produto = 1
p = 0
Lista10n = [p]

for i in range(1,11):

    Lista10n.append(int(input('Digite 10 numeros inteiros para demonstrar a soma, multiplicação e os numeros em listas: ')))

for n in range(1, len(Lista10n)):

    produto = produto * n

print('A soma dos numeros é: ', sum(Lista10n))
print('A multiplicação dos numeros é:', produto)
print('A lista de 10 numeros digitados é:', Lista10n[1:])


    

