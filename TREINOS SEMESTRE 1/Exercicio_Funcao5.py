def somarvalores(x,y):
    if x > y:
        p = x
        x = y
        y = p

    soma = 0

    if y - x > 0: # indica que esta dentro do intervalo. Se o maior - menor der > 0, existe um intervalo dentre eles certo?
        for i in range (x,y+1):
            soma += i
    return soma

x = int(input('Digite o valor de x : '))
y = int(input('Digite o valor de y : '))

resultado = somarvalores(x,y)
print(resultado)