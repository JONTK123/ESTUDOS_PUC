def suce_ante(y):
    sucessor = y + 1
    antecessor = y - 1
    return sucessor, antecessor

n = int(input('Digite um n: '))
resultado = suce_ante(n)
print(resultado)


