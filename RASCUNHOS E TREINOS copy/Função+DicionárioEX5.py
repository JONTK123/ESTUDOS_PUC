# Exercício 5: Calcular a média de valores únicos em um dicionário.
# Escreva uma função que recebe um dicionário como argumento e calcula a média dos valores únicos presentes no dicionário, desconsiderando valores repetidos.




def media_dict(dicionario):
    j = 0
    somatoria = 0


    for valores in dicionario.values():
        valores_unicos = set(valores)
        somatoria = sum(valores_unicos)
        j = len(valores_unicos)
    
    media = somatoria / j 
    return media


   # return media




dicionario = {}
a = 'a'
dicionario[a] = [6,5,3,5,66,33,2,231,23,1,1,2,3,3,3]
print(dicionario)

resultado = media_dict(dicionario)
print(f'resultado:.2f')