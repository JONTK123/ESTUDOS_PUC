'''Faça um programa que mostre os números entre 1000 e 2000 que, quando
divididos por 11 produzam resto igual a 5'''

for k in range(1000,2001):
    if k % 11 == 5:
        print(k)