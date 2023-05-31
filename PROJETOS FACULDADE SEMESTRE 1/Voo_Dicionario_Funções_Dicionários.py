'''Thiago Luiz Fossa, João Giaretta, Gustavo Bicaletto, Enzo Quattrochi'''

def inserir(Voos):
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

    return Voos

def alterar(Voos):

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
            
            print(f"{Voos[codbusca]}\n")
    return Voos

def apagar(Voos):

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
        
    return Voos

def cidade_origem(Voos):

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
    return i

def Voo_menor_escalas(Voos):

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
    return voomenorescala

def cidade_origem2(Voos):

    while True:
        try: 
            destino = input('Digite a cidade DESTINO para determinar quais cidades Origem possuem esse destino: ').upper()
            break
        except ValueError:
            print("Digite o nome da cidade")

    city_origem = []

    for values in Voos.values():
        if destino == values[1]:
            city_origem.append(values[0])
    
    print(city_origem)
    return city_origem

voos = {}

while True:
    print("Menu\n")
    print("1. Inserir Voo")
    print("2. Alterar Informações")
    print("3. Apagar Voo")
    print("4. Determinar Voos que saiem da cidade")
    print("5. Determinar Voo com menor numero de Escalas")
    print("6. Determinar as cidades de origem que possuem o mesmo destino")
    print("7. Sair\n")

    while True:
        try: 
            num = int(input("Digite o numero da opção que deseja acessar: "))
            break
        except ValueError:
            print("Digite o número da opção")

    
    if num == 1:
        while True:
            inserir(voos)
            print(f"{voos}\n") 
            break
            
    if num == 2:
        while True:
            alterar(voos)
            break

    if num == 3:
        while True:
            apagar(voos)
            break
    
    if num == 4:
        while True:
            cidade_origem(voos)
            break

    if num == 5:
        while True:
            Voo_menor_escalas(voos)
            break

    if num == 6:
        while True:
            cidade_origem2(voos)
            break
    
    if num == 7:
        print('Encerrando o programa...')
        break






