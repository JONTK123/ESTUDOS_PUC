# #sequencia de numero

# def sequencia(n):
#     if n == 0:
#         return []
#     else:
#         return [n] + sequencia(n-1)

# n = int(input('Digite um n: '))
# resultado = sequencia(n)
# print(resultado)

#--------------------------------------------------------------------------------------------------------------

# outro metodo

#--------------------------------------------------------------------------------------------------------------

def sequencia(n):
    if n > 0:
        #print(sequencia(n-1)) # RESULTA EM NONE POIS NAO EXISTE UM RETORNADO PARA ESSA FUNCAO, e para o print eh necessario q tenha um valor retornado
        print(n)
        sequencia(n-1) # Realiza todas as recursivas enquanto o print fica em stand by
        
n = 5
sequencia(n)

#--------------------------------------------------------------------------------------------------------------
