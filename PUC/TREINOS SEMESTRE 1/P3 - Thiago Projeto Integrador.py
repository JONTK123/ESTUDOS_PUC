import oracledb

connection = oracledb.connect(
user="SYSTEM",
password="1212",
dsn="localhost/xe")

cursor = connection.cursor()

# Menu 

while True:
    #print("{:^40}".format("Menu\n")) Maneira de printar usando .format
    print('-'*50)
    print('Menu'.center(37)) # Maneira q eu ja sabia 
    print('Sistema De Qualidade Do Ar'.center((37)))
    print('1 - Adicionar Amostras')
    print('2 - Alterar Amostras')
    print('3 - Excluir Amostras') # Não é necessário o .center
    print('4 - Classificar Amostras')
    print('5 - Sair Do Programa')
    print('-'*50)

    while True:
        try:
            Resp = int(input('Digite a função desejada:\n '))
            break
        except Exception:
            print('Digite um número inteiro...\n')
    
    if Resp == 1:
        while True:
            print('-'*50)
            print('\nAdicionar Amostras'.center((37))) 
            print('Sistema De Qualidade Do Ar'.center((37)))

            pi = int(input('Digite o valor de MP10: ')) # Digitar variaveis inserindo no BD
            pif = int(input('Digite o valor de MP25: '))
            oz = int(input('Digite o valor de O3:  '))
            co = int(input('Digite o valor de CO:  '))
            nit = int(input('Digite o valor de N2:  '))
            enx = int(input('Digite o valor de SO2:  '))

            cursor.execute(f"INSERT INTO gases (pi,pif,oz,co,nit,enx) VALUES ({pi},{pif},{oz},{co},{nit},{enx})") 
            connection.commit()

            '''Para executar funções do sql no python, é necessário sempre fazer o cursos.execute(Função desejada do sql)
            e dai na linha seguinta executar o connection.commit() que basicamente envia para o BD o que foi feito assim
            como é para dar COMMIT la no BD caso queira mudar alguma coisa la e efetivar aqui'''

            Resp == 0 # Reinicia a pergunta, caso contrario vai entrar infinitamente na opção do menu 1.
            break  # Finaliza o While. É while pois caso o usuario queira inserir novamente, repete todo o processo infinitamente ate break.
    
    if Resp == 2:
        while True:
            print('-'*50)
            print('Alterar Amostras'.center((37)))
            print('Sistema De Qualidade Do Ar\n'.center((37)))
            print('Tabela:')

            print('-'*80)
            print('{:>10} {:>10} {:>10} {:>10} {:>10} {:>10} {:>10}'.format('ID', 'MP10', 'MP25', 'O3', 'CO', 'N2', 'SO2'))
            print('-'*80)

            cursor.execute(f'SELECT * FROM gases')
            linhasBD = cursor.fetchall()

            for linhas in linhasBD:
                id_bd, pi_bd, pif_bd, oz_bd, co_bd, nit_bd, enx_bd = linhas
                print('{:>10} {:>10} {:>10} {:>10} {:>10} {:>10} {:>10}'.format(id_bd, pi_bd, pif_bd, oz_bd, co_bd, nit_bd, enx_bd))  
            
            print('-'*80)

            while True:
                try:
                    id = int(input('Digite o ID que deseja alterar: ')) 
                    break
                except Exception:
                    print('Digite um número inteiro...\n')

            pi = int(input('Digite o valor de MP10: ')) # Digitar variaveis inserindo no BD
            pif = int(input('Digite o valor de MP25: '))
            oz = int(input('Digite o valor de O3:  '))
            co = int(input('Digite o valor de CO:  '))
            nit = int(input('Digite o valor de N2:  '))
            enx = int(input('Digite o valor de SO2:  '))

            cursor.execute(f'UPDATE gases SET pi = {pi},pif = {pif},co = {co},oz = {oz},nit = {nit},enx = {enx} WHERE id_gases = {id}')
            connection.commit()

            cursor.execute(f'SELECT * FROM gases WHERE id_gases = {id}')
            linhalterada = cursor.fetchone()

            print('-'*80)

            print('{:>10} {:>10} {:>10} {:>10} {:>10} {:>10} {:>10}'.format('ID', 'MP10', 'MP25', 'O3', 'CO', 'N2', 'SO2'))
        
            id_bda, pi_bda, pif_bda, oz_bda, co_bda, nit_bda, enx_bda = linhalterada
            print('{:>10} {:>10} {:>10} {:>10} {:>10} {:>10} {:>10}'.format(id_bda, pi_bda, pif_bda, oz_bda, co_bda, nit_bda, enx_bda)) 

            print('-'*80)

            Resp == 0
            break

        

            break





    if Resp == 5:
        break
    

