def Nperfeito(x):
    if sum(lista) == x:
        print(lista)
        return ' Numero perfeito ' 
    else:
        return ' Numero imperfeito '

'''lista = []
for i in range( 1, x ):
    if x % i == 0:
        lista.append(i)

nperfeito = Nperfeito(x)
print(nperfeito)'''

# CRIAR FUNCAO DE CRIAR LISTA

def criarLista():
    lista = []
    for i in range( 1, x ):
        if x % i == 0:
            lista.append(i)
    return lista

x = int(input('Digite um numero: '))

lista = criarLista()
nperfeito = Nperfeito(x)
print(nperfeito)

     


