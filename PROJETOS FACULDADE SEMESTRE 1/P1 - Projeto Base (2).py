

'''Valores:
Índice da qualidade do ar
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
i = 0
while i > 10:
#Apresentação
    print('-'*30)
    print('Calculadora da qualidade do ar')
    print('-'*30)
    print('Como funciona o cálculo?\nO cálculo funciona da seguinte maneira: são solicitados os valores utilizados no cálculo original da qualidade do ar, de acordo com a Cetesb. Após isso, o pior parâmetro é selecionado e classifica a qualidade do ar entre as possíveis opções:\033[m\n\033[32mN1 - Boa\033[m\n\033[33mN2 - Moderada\033[m\n\033[34mN3 - Ruim\033[m\n\033[31mN4 - Muito ruim\033[m\n\033[35mN5 - Péssima\033[m')
    print('\033[1mATENÇÃO: OS VALORES DEVEM ESTAR NAS UNIDADES DE MEDIDA DEFINIDAS PELO ORGÃO RESPONSÁVEL\033[m.')
    
    #Variáveis definidas
    indice = 0
    validacao = 0
    
    #Laço para preenchimento e validação dos valores das variáveis
    while validacao < 6:
        while validacao == 0:
            pi = int(input('Partículas inaláveis: '))
            if pi < 0:
                print('O valor inserido não pode ser inferior a 0. Insira-o novamente!')
            else:
                validacao += 1
        while validacao == 1:
            pif = int(input('Partículas inaláveis finas: '))
            if pif < 0:
                print('O valor inserido não pode ser inferior a 0. Insira-o novamente!')
            else:
                validacao += 1
        while validacao == 2:
            oz = int(input('Ozônio: '))
            if oz < 0:
                print('O valor inserido não pode ser inferior a 0. Insira-o novamente!')
            else:
                validacao += 1
        while validacao == 3:
            co = int(input('Monóxido de carbono: '))
            if co < 0:
                print('O valor inserido não pode ser inferior a 0. Insira-o novamente!')
            else:
                validacao += 1
        while validacao == 4:
            nit = int(input('Dióxido de nitrogênio: '))
            if nit < 0:
                print('O valor inserido não pode ser inferior a 0. Insira-o novamente!')
            else:
                validacao += 1
        while validacao == 5:
            enx = int(input('Dióxido de enxofre: '))
            if enx < 0:
                print('O valor inserido não pode ser inferior a 0. Insira-o novamente!')
            else:
                validacao += 1
    
    #Condições para definir a qualidade do ar 
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
    
    #[ANTIGO] Condições para definir a qualidade do ar
    '''if pi > 250 or pif > 125 or fmc > 200 or oz > 15 or nit > 1130 or enx > 800:
        indice = 5
    elif 150 < pi <= 250 or 75 < pif <= 125 or 160 < fmc <= 200 or 13 < oz <= 15 or 320 < nit <= 1130 or 365 < enx <= 800:
        indice = 4
    elif 100 < pi <= 150 or 50 < pif <= 75 or 130 < fmc <= 160 or 11 < oz <= 13 or 240 < nit <= 320 or 40 < enx <= 365:
        indice = 3
    elif 50 < pi <= 100 or 25 < pif <= 50 or 100 < fmc <= 130 or 9 < oz <= 11 or 200 < nit <= 240 or 20 < enx <= 40:
        indice = 2
    else:
        indice = 1'''
    
    #Avaliação da qualidade do ar e suas consequências
    if indice == 1:
        print('A qualidade do ar é \033[1;32mN1 - BOA\033[m. Não há riscos para a saúde')
    elif indice == 2:
        print('A qualidade do ar é \033[1;33mN2 - Moderada\033[m. Pessoas de grupos sensíveis (crianças, idosos e pessoas com doenças respiratórias e cardíacas) podem apresentar sintomas como tosse seca e cansaço. A população, em geral, não é afetada.')
    elif indice == 3:
        print('A qualidade do ar é \033[1;34mN3 - Ruim\033[m. Toda a população pode apresentar sintomas como tosse seca, cansaço, ardor nos olhos, nariz e garganta. Pessoas de grupos sensíveis (crianças, idosos e pessoas com doenças respiratórias e cardíacas) podem apresentar efeitos mais sérios na saúde.')
    elif indice == 4:
        print('A qualidade do ar é \033[1;31mN4 - Muito ruim\033[m. Toda a população pode apresentar agravamento dos sintomas como tosse seca, cansaço, ardor nos olhos, nariz e garganta e ainda falta de ar e respiração ofegante. Efeitos ainda mais graves à saúde de grupos sensíveis (crianças, idosos e pessoas com doenças respiratórias e cardíacas).')
    else:
        print('A qualidade do ar é \033[1;35mN5 - Péssima\033[m. Toda a população pode apresentar sérios riscos de manifestações de doenças respiratórias e cardiovasculares. Aumento de mortes prematuras em pessoas de grupos sensíveis.')