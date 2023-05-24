Livros = {}

qntl = int(input('Digite a quantidade de livros:\n '))

for i in range (qntl):

    cod = int(input('Digite o codigo do livro ( 3 digitos de preferencia ):\n '))
    lista_aux = []

    tit = input('Digite o titulo do livro:\n ').upper()
    lista_aux.append(tit)
    nu_autor = int(input('Digite o numero de autores do livro:\n '))
    lista_aux.append(nu_autor)
    autores = []
    for j in range (nu_autor): 
        no_autor = input('Digite o(s) nome(s) do(s) autor(es):\n ') 
        autores.append(no_autor) 
        lista_aux.append(autores)
    preco = float(input('Digite o valor do livro:\n '))

    Livros[cod] = lista_aux # Cracao do dicionario, coloca todos os valores da lista dentro dele

print(Livros) # Printa dicionario