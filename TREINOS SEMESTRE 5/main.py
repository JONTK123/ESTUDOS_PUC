import random
import sys

def verificar_valores(intervalo_minimo, intervalo_maximo):
    if intervalo_minimo is None or intervalo_maximo is None:
        raise ValueError("Erro: parâmetros inválidos. Os valores não podem ser None.")
    if intervalo_minimo > intervalo_maximo:
        raise ValueError("Erro: O intervalo mínimo não pode ser maior que o intervalo máximo.")

def gerar_lista_numeros_aleatorios(intervalo_minimo, intervalo_maximo):
    numeros_aleatorios = []
    for _ in range(10):
        numeros_aleatorios.append(random.randint(intervalo_minimo, intervalo_maximo))
    return numeros_aleatorios

def calcular_soma_media(numeros):
    if not numeros:  # Verifica se a lista está vazia
        raise ValueError("Erro: A lista de números está vazia.")

    soma = sum(numeros)
    media = soma / len(numeros)
    return soma, media

def modificar_numeros_com_base_media(numeros, media):
    for i in range(len(numeros)):
        if numeros[i] > media:
            numeros[i] = numeros[i] - 5
        else:
            numeros[i] = numeros[i] + 5
    return numeros

def exibir_resultados(numeros, media, intervalo_minimo, intervalo_maximo):
    print("Dados gerados:", numeros)
    print("Média calculada:", media)
    if media > ((intervalo_minimo + intervalo_maximo) / 2):
        print("Média acima da expectativa!")
    else:
        print("Média abaixo da expectativa!")

def executar_analise(intervalo_minimo, intervalo_maximo):
    try:
        verificar_valores(intervalo_minimo, intervalo_maximo)
        numeros = gerar_lista_numeros_aleatorios(intervalo_minimo, intervalo_maximo)
        soma, media = calcular_soma_media(numeros)
        numeros_ajustados = modificar_numeros_com_base_media(numeros, media)
        exibir_resultados(numeros_ajustados, media, intervalo_minimo, intervalo_maximo)

    except ValueError as e:
        print(f"Erro de valor: {e}")
    except Exception as e:
        print(f"Erro inesperado: {e}") # Erros que não foram definidos

# Execução da função com parâmetros fixos
executar_analise(10, 50)