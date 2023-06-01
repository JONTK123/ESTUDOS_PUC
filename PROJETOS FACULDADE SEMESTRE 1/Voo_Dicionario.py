'''Thiago Luiz Fossa, Gustavo Bicaletto, '''

while True:
    try: 
        qntl = int(input('Digite a quantidade de voos que desejar:\n '))
        break 
    except ValueError:
        print('Tem que ser numero inteiro...') 

Voos = {}
    
for i in range (qntl):

    codvoo = int(input('Digite o codigo do voo ( 3 digitos de preferencia ):\n ')) 
    cidadeorigem = input('Digite a cidade de origem:\n ').upper()
    cidadedestino = input('Digite a cidade destino:\n ').upper()
    Numescalas = int(input('Digite o numero de escalas:\n'))
    if Numescalas > 0: # E se nao tiver escalas?
        cidadescalal = []
        for i in range(Numescalas):
            cidadescala = input('Digite a(s) cidade(s) escala:\n').upper()
            cidadescalal.append(cidadescala)
        Voos[codvoo] = [cidadeorigem, cidadedestino, Numescalas, cidadescalal] 
    else: 
        Voos[codvoo] = [cidadeorigem, cidadedestino, Numescalas] 

print(Voos) 

while True:
    try: 
        Perg1 = input('Deseja alterar informções de algum voo: (S/N) ').upper()
        break 
    except ValueError:
        print('Tem que digitar (S/N)...')

if Perg1 == 'S':

    while True:
        try: 
            codbusca = int(input('Digite o codigo do voo que deseja alterar: '))
            break 
        except ValueError:
            print('Tem que ser numero inteiro...') 
    
    for keys, values in Voos.items():

        if codbusca == keys:
            print(f'Informações deste voo -> {keys, values}')

            cidadeorigem = input('Digite a cidade de origem:\n ').upper()
            cidadedestino = input('Digite a cidade destino:\n ').upper()
            Numescalas = int(input('Digite o numero de escalas:\n'))
            if Numescalas > 0:
                cidadescalal = []
                for i in range(Numescalas):
                    cidadescala = input('Digite a(s) cidade(s) escala:\n').upper()
                    cidadescalal.append(cidadescala)
                Voos[keys] = [cidadeorigem, cidadedestino, Numescalas, cidadescalal] 
            else: 
                Voos[keys] = [cidadeorigem, cidadedestino, Numescalas] 
            
            print(Voos)
    
while True:
    try: 
        Perg2 = input('Deseja excluir algum voo: (S/N) ').upper()
        break 
    except ValueError:
        print('Tem que digitar (S/N)...')

if Perg2 == 'S':

    while True:
        try: 
            codbusca = int(input('Digite o codigo do voo que deseja apagar: '))
            break 
        except ValueError:
            print('Tem que ser numero inteiro...') 

    for keys, values in Voos.items():
        if codbusca == keys:
            del Voos[codbusca]
            print(Voos)

while True:
    try: 
        Perg3 = input('Digite a cidade ORIGEM para saber quantos voos saem dela: ').upper()
        break 
    except ValueError:
        print('Tem que digitar A CIDADE...')

i = 0

for keys, values in Voos.items():
        if Perg3 == values[0]:
            i += 1
        else:
            print('Nao ha voos que saem desta cidade...')

print(f'Quantidade de voos que saem desta cidade origem: {i}')

while True:
    try: 
        Perg4 = input('Digite a cidade ORIGEM para determinar o voo com menor número de escalar: ').upper()
        Perg5 = input('Digite a cidade DESTINO para determinar o voo com menor número de escalar: ').upper()
        break 
    except ValueError:
        print('Tem que digitar A CIDADE...')

menorNescalas = 10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000 

for keys, values in Voos.items():
    if Perg4 == values[0] and Perg5 == values[1]: 
        if values[2] < menorNescalas: 
            menorNescalas = values[2]
            voomenorescala = keys,values
        else: 
            print("Não há voos entre essas cidades") 

print(voomenorescala) 


