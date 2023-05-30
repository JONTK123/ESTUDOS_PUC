# Calcular o fatorial de um número:

def fatorial(n):
    return n * ( n - 1)

n = int(input('n: '))
resultado = fatorial(n)
print(resultado)