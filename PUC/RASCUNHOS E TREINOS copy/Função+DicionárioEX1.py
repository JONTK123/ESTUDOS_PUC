# EXEMPLO DE EXERCICIO COM FUNCIONÁRO

# def adicionar_produto(dicionario, nome, preco):
#     dicionario[nome] = preco
#     print(f"Produto '{nome}' adicionado com sucesso.")

# def verificar_produto(dicionario, nome):
#     if nome in dicionario:
#         print(f"O produto '{nome}' existe.")
#     else:
#         print(f"O produto '{nome}' não existe.")

# def exibir_produtos(dicionario):
#     print("Lista de Produtos:")
#     for nome, preco in dicionario.items():
#         print(f"Produto: {nome}, Preço: R${preco:.2f}")

# # Dicionário de produtos vazio
# produtos = {}

# # Adicionando produtos ao dicionário
# adicionar_produto(produtos, "Camiseta", 29.90)
# adicionar_produto(produtos, "Calça Jeans", 79.90)
# adicionar_produto(produtos, "Tênis", 99.90)

# # Verificando se um produto existe
# verificar_produto(produtos, "Camiseta")
# verificar_produto(produtos, "Meia")

# # Exibindo todos os produtos
# exibir_produtos(produtos)

# ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

# Exercício 1: Calcular a soma dos valores de um dicionário. Escreva uma função que recebe um dicionário como argumento e retorna a soma de todos os valores presentes no dicionário.

def somar_dicionario(dicionario):
    soma = sum(dicionario.values())
    return soma

def criar_dicionario():
    dicionario = {}
    x = int(input('Digite o numero de vezes:'))
    for i in range(x):
        chave = input('Digite uma letra: ')
        valor = int(input(f'Digite o valor da {chave}: '))
        dicionario[chave] = valor 
    print(dicionario)
    return dicionario

resultado = somar_dicionario(criar_dicionario())
print(resultado)


