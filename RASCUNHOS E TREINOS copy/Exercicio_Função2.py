# '''def ler_numero(): # Def função, Nome função, () vazios pois nao precisa chamar
#     n = int(input("Digite o valor de um Numero inteiro: ")) 
#     return n

# def somar(n1,n2,n3):
#     resultado = (n1 + n2 + n3)
#     return resultado

# n1 = ler_numero()
# n2 = ler_numero()
# n3 = ler_numero()

# resp = somar(n1,n2,n3)
# print(resp)'''

def ler():
    n = int(input('Digite um numero n: '))
    return n # Vou salvar como reusultado dessa funcao como n

def soma(numero_inserido1, numero_inserido2, numero_inserido3):
    resultado = numero_inserido1 + numero_inserido2 + numero_inserido3
    print(resultado)
    return resultado # Vou salvar como reusultado dessa funcao com resultado

n1 = ler() # return do n do m1
n2 = ler() # return do n do m2
n3 = ler() # return do n do m3

soma(n1,n2,n3)



