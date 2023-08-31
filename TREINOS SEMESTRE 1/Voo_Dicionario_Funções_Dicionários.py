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
        print("Voos")
        print(f'\n Codígo\t          Cidade Origem\t        Cidade Destino\t   Num Escala\t  Cidade Escala')
        print("*"*100)
        for keys, values in voos.items():
            if keys == codvoo:
                codigo = keys
                cidadeorigem = values[0]
                cidadedestino = values[1]
                Numescalas = values[2]
                cidadescalal = values[3]
                print('\n {:^8}\t{:^22}\t{:^12}\t{:^22}\t{:^2}'.format(codigo,cidadeorigem,cidadedestino,Numescalas,cidadescalal[0]))
                if Numescalas > 0:
                    for row in range(1,len(cidadescalal)):
                        print('\t\t\t\t\t\t\t\t\t      {:^10}'.format(cidadescalal[row]))
                print("*"*100)
    else: 
        Voos[codvoo] = [cidadeorigem, cidadedestino, Numescalas]
        print("Voos")
        print(f'\n Codígo\t          Cidade Origem\t        Cidade Destino\t   Num Escala\t  Cidade Escala')
        print("*"*100)
        for keys, values in voos.items():
            if keys == codvoo:
                codigo = keys
                cidadeorigem = values[0]
                cidadedestino = values[1]
                Numescalas = values[2]
                print('\n {:^8}\t{:^22}\t{:^12}\t{:^22}'.format(codigo,cidadeorigem,cidadedestino,Numescalas))
                print("*"*100)
    return Voos

def alterar(Voos):

    while True:
        print("Voos")
        print(f'\n Codígo\t          Cidade Origem\t        Cidade Destino\t   Num Escala\t  Cidade Escala')
        print("*"*100)
        for keys, values in voos.items():
                    codigo = keys
                    cidadeorigem = values[0]
                    cidadedestino = values[1]
                    Numescalas = values[2]
                    if Numescalas > 0:
                        cidadescalal = values[3]
                        print('\n {:^8}\t{:^22}\t{:^12}\t{:^22}\t{:^2}'.format(codigo,cidadeorigem,cidadedestino,Numescalas,cidadescalal[0]))
                        for row in range(1,len(cidadescalal)):
                            print('\t\t\t\t\t\t\t\t\t      {:^10}'.format(cidadescalal[row]))
                            
                    else: 
                        print('\n {:^8}\t{:^22}\t{:^12}\t{:^22}'.format(codigo,cidadeorigem,cidadedestino,Numescalas))
        print("*"*100)               
        try:        
            codbusca = int(input('Digite o codigo do voo que deseja alterar: '))
            break 
        except ValueError:
            print('Tem que ser numero inteiro...') 

    for keys, values in voos.items():

        if codbusca == keys:

            cidadeorigem = input('Digite a cidade de origem:\n ').upper()
            cidadedestino = input('Digite a cidade destino:\n ').upper()
            Numescalas = int(input('Digite o numero de escalas:\n'))
            if Numescalas > 0:
                cidadescalal = []
                for i in range(Numescalas):
                    cidadescala = input('Digite a(s) cidade(s) escala:\n').upper()
                    cidadescalal.append(cidadescala)
                Voos[codbusca] = [cidadeorigem, cidadedestino, Numescalas, cidadescalal]
                print("Voos")
                print(f'\n Codígo\t          Cidade Origem\t        Cidade Destino\t   Num Escala\t  Cidade Escala')
                print("*"*100)
                for keys, values in voos.items():
                    if keys == codbusca:
                        codigo = keys
                        cidadeorigem = values[0]
                        cidadedestino = values[1]
                        Numescalas = values[2]
                        cidadescala = values[3]
                        print('\n {:^8}\t{:^22}\t{:^12}\t{:^22}\t{:^2}'.format(codigo,cidadeorigem,cidadedestino,Numescalas,cidadescala[0]))
                        if Numescalas > 0:
                            for row in range(1,len(cidadescalal)):
                                print('\t\t\t\t\t\t\t\t\t      {:^10}'.format(cidadescala[row]))
                        print("*"*100)
            else: 
                Voos[codbusca] = [cidadeorigem, cidadedestino, Numescalas]
                print("Voos")
                print(f'\n Codígo\t          Cidade Origem\t        Cidade Destino\t   Num Escala\t  Cidade Escala')
                print("*"*100)
                for keys, values in voos.items():
                    if keys == codbusca:
                        codigo = keys
                        cidadeorigem = values[0]
                        cidadedestino = values[1]
                        Numescalas = values[2]
                        print('\n {:^8}\t{:^22}\t{:^12}\t{:^22}'.format(codigo,cidadeorigem,cidadedestino,Numescalas))
                        print("*"*100)
    return Voos

def apagar(Voos):

    while True:
        print("Voos")
        print(f'\n Codígo\t          Cidade Origem\t        Cidade Destino\t   Num Escala\t  Cidade Escala')
        print("*"*100)
        for keys, values in voos.items():
                    codigo = keys
                    cidadeorigem = values[0]
                    cidadedestino = values[1]
                    Numescalas = values[2]
                    if Numescalas > 0:
                        cidadescalal = values[3]
                        print('\n {:^8}\t{:^22}\t{:^12}\t{:^22}\t{:^2}'.format(codigo,cidadeorigem,cidadedestino,Numescalas,cidadescalal[0]))
                        for row in range(1,len(cidadescalal)):
                            print('\t\t\t\t\t\t\t\t\t      {:^10}'.format(cidadescalal[row]))
                            
                    else: 
                        print('\n {:^8}\t{:^22}\t{:^12}\t{:^22}'.format(codigo,cidadeorigem,cidadedestino,Numescalas))
        print("*"*100)               

        try: 
            codbusca = int(input('Digite o codigo do voo que deseja apagar: '))
            break 
        except ValueError:
            print('Tem que ser numero inteiro...') 

    voos.pop(codbusca)
    print("Voo Apagado com Sucesso!!!\n")
        
    return Voos

def cidade_origem(Voos):

    while True:
        try: 
            Perg3 = input('Digite a cidade ORIGEM para saber quantos voos saem dela: ').upper()
            break 
        except ValueError:
            print('Tem que digitar A CIDADE...')
    
    i = 0
    
    for keys, values in voos.items():
            if Perg3 == values[0]:
                i += 1

    if i > 0:
        print(f'\nQuantidade de voos que saem de {Perg3} são: {i}\n')
    else:
        print('\nNao ha voos que saem desta cidade...\n')

    return i

def Voo_menor_escalas(Voos):

    while True:
        try: 
            Perg4 = input('Digite a cidade ORIGEM para determinar o voo com menor número de escalar: ').upper()
            Perg5 = input('Digite a cidade DESTINO para determinar o voo com menor número de escalar: ').upper()
            break 
        except ValueError:
            print('Tem que digitar A CIDADE...')

    menorNescalas = 10000

    i = 0
    for keys, values in voos.items():
        if Perg4 == values[0] and Perg5 == values[1]: 
            if values[2] < menorNescalas: 
                menorNescalas = values[2]
                voomenorescala = keys,values
            else:
                i +=1

    if i > 0:
        print(f"\nInformações do Voo com menor escala:\n{voomenorescala}\n")
    else:
        print("Não há voos entre essas cidades") 

    return voomenorescala

def cidade_origem2(Voos):

    while True:
        try: 
            destino = input('Digite a cidade DESTINO para determinar quais cidades Origem possuem esse destino: ').upper()
            break
        except ValueError:
            print("Digite o nome da cidade")

    city_origem = []
    i = 0

    for values in voos.values():
        if destino == values[1]:
            city_origem.append(values[0])
            i += 1
    
    if i > 0:
        print(f"\nAs cidades que possuem esse destino são:\n{city_origem}\n")
    else:
        print("Cidade de destino não cadastrada!!")
        
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






