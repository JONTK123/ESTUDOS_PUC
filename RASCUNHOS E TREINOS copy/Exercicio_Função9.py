# Elabore um programa que leia um número inteiro e construa duas funções: uma que
# some os dígitos desse número inteiro e outra que determine o maior digito desse
# número


def soma_digitos(n):
    soma = sum(n)
    return soma

def maior_digito(n):
    maior = 0
    for i in n:
        if i > maior:
            maior = i
    return maior

x = input('x: ')
n = []
for i in x:
    numero = int(i)
    n.append(numero)

resultado = soma_digitos(n)
resultado2 = maior_digito(n)

print(resultado,resultado2)