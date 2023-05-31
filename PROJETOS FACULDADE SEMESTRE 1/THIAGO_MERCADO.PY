# ETAPA 1 - Pedir senha ao usuario para abrir o caixa, 3 tentativas erradas = seistema deve ser reinicializado

#Senha = 2987

#senha = int(input('Ola, para acessar o caixa digite a senha de 4 digitos:'))

'''for tentativas in range (3,0,-1):

    if senha == 2987:
        print('Caixa aberto!!!')
        break

    if senha != 2987 and tentativas == 3:
        print(f'Voce tem direito a mais 2 tentativas')
        senha = int(input('Errado, para acessar o caixa digite a senha de 4 digitos:'))

    elif senha != 2987 and tentativas == 2:
        print(f'Voce tem direito a mais 1 tentativas')
        senha = int(input('Errado, para acessar o caixa digite a senha de 4 digitos:'))

    elif senha != 2987 and tentativas == 1:
        print('Senha incorreta!')
        print('O sistema precisa ser reiniciado')'''

#--------------------------------------------------------------------------------------------------------------------
#--------------------------------------------------------------------------------------------------------------------

'''senha = 0

while senha != 2987:

    senha = int(input('Ola, para acessar o caixa digite a senha de 4 digitos:'))

    if senha != 2987:
        print('Senha incorreta...')
        print('Voce tem direito a mais 2 tentativas')
        senha = int(input('Ola, para acessar o caixa digite a senha de 4 digitos:'))

    if senha != 2987:
        print('Senha incorreta...')
        print('Voce tem direito a mais 1 tentativa')
        senha = int(input('Ola, para acessar o caixa digite a senha de 4 digitos:'))
        
    if senha != 2987:
        print('Senha incorreta...')
        print('O sistema precisa ser reinicializado!!!')
        break

    if senha == 2987:
        print('Caixa aberto!!!')
        break'''

#--------------------------------------------------------------------------------------------------------------------
#--------------------------------------------------------------------------------------------------------------------

senha = 0
i = 4

while True:

    senha = int(input('Ola, para acessar o caixa digite a senha de 4 digitos:'))
    i -= 1

    if senha == 2987:
        print('Caixa aberto!!!')
        break

    if i == 3:
        print('Senha incorreta...')
        print(f'Voce tem mais {i-1} tentativas')
    
    if i == 2:
        print('Senha incorreta...')
        print(f'Voce tem mais {i-1} tentativas')
        
    if i == 1:
        print('Senha incorreta...')
        print('O sistema precisa ser reinicializado!!!')
        break

# Escolhi esse metodo, continuando o programa.

# Definicao do caixa para troco e divisao das notas.

if senha == 2987:

# Numero de notas de 200,100,50...

    caixa = 1280 
    nDuz = 2
    nCem = 4
    nCinq = 6
    nDez = 10
    nCinc = 5
    nUm = 1
    nCents = 0,5

# limite de notas para usar no troco, tem que ter um litmite se nao como ele vai definir quantas notas foram usadas?

    lDuz = 0
    lCem = 0
    lCinq = 0
    lDez = 0
    lCinc = 0
    lUm = 0
    lCents = 0

    #--------------------------------------------------------------------------------------------------------------------
    #--------------------------------------------------------------------------------------------------------------------

    # Leitura das vendas e manipulacao da lista de compras pelo comprador

    ValorTotal = 0
    UltimoValor = 0
    ValorTotalCliente = 0
    j = 0
    Nclientes = 1
    valorAnterior = 0
    Valortotaloperações = 0
    Resp = 'N'

    print('Insercao de itens no caixa!!!')
    print('Digite 0 para parar...')
    print('Digite -1 para corrigir algum item engano...')

    while Resp == 'N':
        j += 1
        ValorItem = float(input(f'Digite o valor do item {j} a ser cobrado: R$ '))
        

        if ValorItem == 0:
            Resp = input('Deseja realmente fechar o caixa? Digite S para sim e N para nao: ').upper()
            if Resp == 'S':
                print(f'Venda finalizada com {j} item(s)')
                break

        if ValorItem == -1:
            j -= 1
            ValorTotalCliente -= valorAnterior
            ValorItem = float(input(f'Digite o valor CORRETO do item {j} a ser cobrado: R$ '))

        ValorTotalCliente += ValorItem
        valorAnterior = ValorItem 

    

        #SALVAR VALOR ANTEROIOR   

    #--------------------------------------------------------------------------------------------------------------------
    #--------------------------------------------------------------------------------------------------------------------

    print('Venda Finalizada!!!')
    print(f'Valor total é igual: {ValorTotalCliente:.2f}')
    ValorPago = float(input('Digite o valor pago EM DINHEIRO: '))
    if ValorTotalCliente == ValorPago:
        print('Não há troco')
    else:

        Troco = ValorPago - ValorTotalCliente

        caixa -= Troco #O dinheiro fornecido como troco é descontado do dinheiro que havia no caixa quando foi aberto

        print(f'O seu troco é: {Troco:.2f}')
        
        i = 0
        while Troco >= 200 and lDuz < nDuz:
            Troco -= 200
            lDuz += 1
            i += 1   
        if lDuz > 0: # FORA DO WHILE POIS SE NAO ELE PRINTA EM LISTA VARIAS VEZES
            print(f"{i} CÉDULA(s) DE 200")

        l = 0
        while Troco >= 100 and lCem < nCem:
            Troco -= 100
            lCem+= 1
            l += 1   
        if lCem > 0:
            print(f"{l} CÉDULA(s) DE 100")

        p = 0
        while Troco >= 50 and lCinq < nCinq:
            Troco -= 50
            lCinq += 1
            p += 1   
        if lCinq > 0:
            print(f"{p} CÉDULA(s) DE 50")

        ç = 0
        while Troco >= 10 and lDez < nDez:
            Troco -= 10
            lDez += 1
            ç += 1   
        if lDez > 0:
            print(f"{ç} CÉDULA(s) DE 10")

        m = 0
        while Troco >= 5 and lCinq < nCinc:
            Troco -= 5
            lCinc += 1
            m += 1   
        if lCinc > 0:
            print(f"{m} CÉDULA(s) DE 5")

        n = 0
        while Troco >= 1 and lUm <= nUm:
            Troco -= 1
            lUm += 1
            n += 1   
        if lUm > 0:
            print(f"{n} CEDULAS DE 1 ")

#--------------------------------------------------------------------------------------------------------------------
#--------------------------------------------------------------------------------------------------------------------

#NAO CONSEGUI FAZER O FECHAMENTO DO CAIXA

# FECHAMENTO FINAL DO CAIXA!!!
    print('FECHAMENTO DO CAIXA!!!')
    print(f'Numero de clientes atendidos: {Nclientes}')
    print(f'Valor total das operações: {ValorTotalCliente}')
    print(f'Dinheiro disponivel no caixa para trocos: ...')

    if (nDuz - lDuz) > 0:
            print(f"{nDuz - lDuz} CÉDULA(s) DE 200")
    if (nCem - lCem) > 0:
            print(f"{nCem - lCem} CÉDULA(s) DE 100")
    if (nCinq - lCinq) > 0:
            print(f"{nCinq - lCinq} CÉDULA(s) DE 50")
    if (nDez - lDez) > 0:
            print(f"{nDez - lDez} CÉDULA(s) DE 10")
    if (nCinc - lCinc) > 0:
            print(f"{nCinc - lCinc} CÉDULA(s) DE 5 ")
    if (nUm - lUm) > 0:
            print(f"{nUm - lUm}  MOEDA(s) DE UM ")

print("Até Breve................")
    
    



            






        

            

        