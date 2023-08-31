# Funcoes

''' def (nome funcao) (parametros):

    ...
    comandos
    ...

    return ( retorna um valor )'''

# Exemplo sem RETURN

'''def Happy_Birthday(name,age):

    print(f'Happy birthday {name}!')
    print(f'You are {age} years old!')
    
Happy_Birthday('Rogerio',99999) # QUando for chamar a funcao, precisa colocar os parenteses'''

# Exemplo com RETURN

def add(x,y):
    sum = x + y
    return sum  # Em programação, a declaração return é usada para especificar o valor que uma função deve retornar quando é chamada O uso do return é importante para que possamos capturar o resultado de uma função 
    
print(add(1,2))

# BASICAMENTE ELE SALVA O RESULTADO DA OPERACAO COMO RESULTADO DA FUNCAO

result = add(1, 2)
print(result)  # Output: 3

another_result = add(result, 5)
print(another_result)  # Output: 8, salvou o resultado da ultima chamada da funcao




