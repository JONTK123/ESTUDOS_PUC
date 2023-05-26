
def calculo_fatorial(x):
    fatorial = 1
    for i in range(1, x+1):
        fatorial*= i
    return fatorial

x = int(input('Digite um numero inteiro: '))
resultado = calculo_fatorial(x)
print(f'O numero: {x} tem seu fatorial como: {resultado}')
    
    