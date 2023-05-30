# Calcular o fatorial de um número:

def fatorial(n):
    return n * ( n - 1) # enquanto o n nao é zero ele nao para

n = int(input('n: '))
resultado = fatorial(n)
print(resultado)