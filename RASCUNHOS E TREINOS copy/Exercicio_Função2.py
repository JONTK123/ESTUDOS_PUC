def ler_numero(): # Def função, Nome função, () vazios pois nao precisa chamar
    n = int(input("Digite o valor de um Numero inteiro: ")) 
    return n

def somar(n1,n2,n3):
    resultado = (n1 + n2 + n3)
    return resultado

n1 = ler_numero()
n2 = ler_numero()
n3 = ler_numero()

resp = somar(n1,n2,n3)
print(resp)

def ler():
    n = int(input('Digite um numero n: '))
    return n # Vou salvar como reusultado dessa funcao como n

def soma(m1,m2,m3):
    resultado = m1 + m2 + m3
    return resultado # Vou salvar como reusultado dessa funcao com resultado

m1 = ler()
m2 = ler()
m3 = ler()

somatoria = soma(m1,m2,m3)
print(somatoria)




    