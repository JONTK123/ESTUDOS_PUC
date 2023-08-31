'''Índice da qualidade do ar
indice

Partículas inaláveis
pi

Partículas inaláveis finas
pif

Ozônio
oz

Monóxido de carbono
co

Dióxido de nitrogênio
nit

Dióxido de enxofre
enx'''

# São 6 particulas/amostras, preciso anotar amostras das 6 delas uma de cada vez e guardar o valor em sua respectiva variavel, caso seja digitado 0, é necessario digitar novamente.


# Definição das amostras

for i in range(1,7):

    pi = int(input('Digite a amostra de Particula Inalavel pi: '))
    if pi == -1:
        print('Não é permitido amostras com valor < ...')
        pi = int(input('Digite NOVAMENTE a amostra de Particula Inalavel: '))
        i -= 1   

    pif = int(input('Digite a amostra de Particula Inalavel Fina pif: '))
    if pif == -1:
        print('Não é permitido amostras com valor < 0...')
        pif = int(input('Digite NOVAMENTE a amostra de Particula Inalavel Fina: '))
        i -= 1
    
    oz = int(input('Digite a amostra de Ozonio oz: '))
    if oz == -1:
        print('Não é permitido amostras com valor < 0...')
        oz = int(input('Digite NOVAMENTE a amostra de Ozonio '))
        i -= 1

    co = int(input('Digite a amostra de Monoxido de Carbono co: '))
    if co == -1:
        print('Não é permitido amostras com valor < 0...')
        co = int(input('Digite NOVAMENTE a amostra de Monoxido de Carbono '))
        i -= 1

    nit = int(input('Digite a amostra de Dioxido de Nitrogenio nit: '))
    if nit == -1:
        print('Não é permitido amostras com valor < 0...')
        nit = int(input('Digite NOVAMENTE a amostra de Dioxido de Nitrogenio: '))
        i -= 1

    enx = int(input('Digite a amostra de Enxofre enx: '))
    if enx == -1:
        print('Não é permitido amostras com valor < 0...')
        enx = int(input('Digite NOVAMENTE a amostra de Enxofre: '))
        i -= 1
    else: break

# Definição dos indices

indice = 0

'''if pi <= 50 or pif <= 25 or oz <= 100 or co <= 9 or nit <= 200 or enx <= 20:
    indice = 1
elif pi <= 100 or pif <= 50 or oz <= 130 or co <= 11 or nit <= 240 or enx <= 40:
    indice = 2
elif pi <= 150 or pif <= 75 or oz <= 160 or co <= 13 or nit <= 320 or enx <= 365:
    indice = 3
elif pi <= 250 or pif <= 125 or oz <= 200 or co <= 15 or nit <= 1130 or enx <= 800:
    indice = 4
else:
    indice = 5'''

if pi > 250 or pif > 125 or oz > 200 or co > 15 or nit > 1130 or enx > 800:
    indice = 5
elif pi > 150 or pif > 75 or oz > 160 or co > 13 or nit > 320 or enx > 365:
    indice = 4
elif pi > 100 or pif > 50 or oz > 130 or co > 11 or nit > 240 or enx > 40:
    indice = 3
elif pi > 50 or pif > 25 or oz > 100 or co > 9 or nit > 200 or enx > 20:
    indice = 2
else:
    indice = 1

print(indice)

if indice == 5:
    print('Qualidade: pessima //// Riscos da saude --> ................... ')
elif indice == 4:
    print('Qualidade: muito ruim //// Riscos da saude --> ................... ')
elif indice == 3:
    print('Qualidade: ruim //// Riscos da saude --> ................... ')
elif indice == 2:
    print('Qualidade: moderada //// Riscos da saude --> ................... ')
else:
    print('Qualidade: boa //// Riscos da saude --> ................... ')
