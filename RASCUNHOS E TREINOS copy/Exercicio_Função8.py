# Elabore um programa que leia dois números inteiros e uma função que some todos os
# valores inteiros contidos no intervalo entre esses dois números. Retorne o resultado da
# soma pelo return

def somar(x1,x2):
    if x1 > x2:
        z = x2
        x2 = x1
        x1 = z
    somatoria = 0
    if x2 - x1 > 0:
        for i in range(x1,x2+1):
            somatoria += i
    return somatoria

x1 = int(input('x: '))
x2 = int(input('x: '))

resultado = somar(x1,x2)
print(resultado)
