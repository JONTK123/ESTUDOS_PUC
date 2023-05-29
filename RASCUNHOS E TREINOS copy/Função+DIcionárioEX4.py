# Exercício 4: Verificar a ocorrência de palavras em uma frase.
# Escreva uma função que recebe uma frase e retorna um dicionário contendo a contagem de ocorrências de cada palavra na frase.


def contagem_de_ocorrencia(frase_lista):
    ocorrencias = {}
    for i in frase_lista:
        if i in ocorrencias:
            ocorrencias[i] += 1
        else:
            ocorrencias[i] = 1
        
    return ocorrencias

frase = 'Enzo não é sozinho, Enzo é safado'

frase_lista = []
for i in frase:
    if i != ' ':
        frase_lista.append(i)
print(frase_lista)


resultado = contagem_de_ocorrencia(frase_lista)
print(resultado)
