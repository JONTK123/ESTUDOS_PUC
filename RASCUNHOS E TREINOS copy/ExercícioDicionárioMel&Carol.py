dicionarioLivros = {}

#erros e excessões
#loop para repetir ate que seja inserido o número da forma correta.
numAutores=0
while True: 
    try: 
        quantidadeLivros= int(input('Digite a quantidade de livros que deseja cadastrar: '))
        break 
    except ValueError:
        print('Digite um numero inteiro.')

for i in range (quantidadeLivros):


    codigolivro=int(input("Digite o código do livro: "))

    tituloLivro=(input("Digite o título do livro: "))

    precoLivro=float(input("Digite o valor do livro: "))

    numAutores=int(input("Quantos autores tem esse livro? "))

autores=[]

for i in range(numAutores):
        
    autorLivro=(input("Digite o nome do autor livro: "))
    autores.append(autorLivro)


dicionarioLivros[codigolivro]=[tituloLivro,precoLivro,autores]

print(dicionarioLivros)


dicionarioLivros[codigolivro]=[tituloLivro,precoLivro,autores]

print(dicionarioLivros)

#procurar o livro pelo título

i=0

titulo=int(input("Digite o codigo do livro que deseja buscar: "))

for keys,values in dicionarioLivros.items():
    if values[0] == titulo:
        print(keys, values)
        i = +1
if i==0:
    print("Este livro não está cadastrado!")


#procurar o livro pelo código

i=0
codigo=int(input("Digite o codigo do livro que deseja buscar: "))

for keys,values in dicionarioLivros.items():
    if codigo in dicionarioLivros.keys():
        print(keys, values)
        i = +1
if i == 0:
    print("Este livro não está cadastrado!")

#imprimir os livros com valor acima de R$50,00

for keys, values in dicionarioLivros.items():
    if values[2] > 50:
        codigolivro = keys
        tituloLivro = values[0]
        precoLivro = values[1]
        autores = values[2]
print(f'Estes são os livros que custam mais de R$50,00: {values[2]}')

