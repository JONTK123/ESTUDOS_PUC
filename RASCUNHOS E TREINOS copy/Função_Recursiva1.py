# Calcular o fatorial de um número:

# def fatorial(n):
#     if n == 0:
#         return 1
#     else:
#         return n * fatorial( n - 1) # enquanto o n nao é zero ele nao para

# n = int(input('n: '))
# resultado = fatorial(n)
# print(resultado)

def fatorial(n):
    if n != 0:
        resultado = n*fatorial(n-1)
        print(resultado)
        return resultado
    else: 
        return 1
    
m = 5
fatorial(m)

# PRECISA COLOCAR CONDICAO DE PARADA OBRIGATORIAMENTE, E SE FOR UTILIZAR A FUNCAO RECURSIVA QUE DEPENDE USAR O SEU PROPRIO RESULTAOD