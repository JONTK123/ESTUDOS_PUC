# Mensagem de boas vindas
print("Bem Vindo!!!".center(40))

# Pedir para inserir a senha (Senha correta = 2987)
i = 3
senha = int(input("Digite a sua senha para abrir o caixa: "))

# Caso a senha seja incorreta, faz a repetição de mais 2 tentativas
while senha != 2987 and i >=1:
    print("SENHA INCORRETA")
    if i == 1:
        print("O sistema precisa ser Reiniciado!!!")
    else:
        print(f"Você tem mais {i-1} tentativa(s) restante(s)")
        senha = int(input("Digite a sua senha para abrir o caixa: "))
    i-=1

# Condição para continuar o programa somente se a senha digitada for correta
if senha == 2987:
    
    print("\nSENHA CORRETA \nCaixa Aberto!!!")  
    # Atribiur variaveis as notas disponiveis no caixa QUANTAS TENHO PARA USAR
    caixa = float(1280)
    duz = 2
    cem = 4
    ciq = 6
    dez = 10
    cin = 10
    um = 20
    cents = 20
    # Numero de clientes atendidos
    nc = 1
    # Quatidade de cedulas utilizadas para o troco Q EU JA USEI
    nduz = 0
    ncem = 0
    nciq = 0
    ndez = 0
    ncin = 0
    num = 0
    ncents = 0

    # Inserção dos valores dos intens vendidos
    print("\nINSERÇÃO DOS ITENS VENDIDOS".center(40))
    n = float(input("Digite o valor do item 1: R$"))
    if n == 0:
      ans = input("Deseja Realmente Finalizar?? (S= Sim/N= Não)")
      ans = ans.upper()
      if ans == 'S':
          print(f"Venda Finalizada com 0 Item")
          exit()
      else:
          n = float(input(f"Digite o valor do item 1: R$"))
    # Definição dos valores bases das variaveis
    cont = 1
    valor = n
    valorantr = n
    # Repetição caso haja mais de 1 iten
    while n != 0:
        n = float(input(f"Digite o valor do item {cont+1}: R$"))
        # Desconsiderar o ultimo valor caso seja digitado -1
        if n == -1:
            if cont == 1:
                valor = 0
                n = float(input(f"Digite o valor correto do item {cont}: R$"))
            else:
                valor -= valorantr
                n = float(input(f"Digite o valor correto do item {cont}: R$"))
            cont -= 1
        # Finalizar a insesrção de valores quando inserido 0
        if n == 0:
            ans = input("Deseja Realmente Finalizar?? (S= Sim/N= Não)")
            ans = ans.upper()
            if ans == 'S':
                print(f"Venda Finalizada com {cont} Itens\n")
                break
            else:
                n = float(input(f"Digite o valor do item {cont+1}: R$"))
        valor+=n
        valorantr = n
        cont+=1 

    # Printar o valor total e solicitar o valor para o pagamento    
    print("\nVENDA FINALIZADA!!!")
    print(f"Valor Total: R${valor:.2f}")
    valorpago = float(input("Valor Pago: R$"))
    if valor == valorpago:
        print("NÃO HÁ TROCO")
    # Realizar o troco e definir quantidade de cedulas
    else:
        troco = (valorpago - valor)
        caixa -= troco
        print(f"Troco: R${troco:.2f}")
        # Definir a quantidade de notas de 200
        while troco >= 200 and nduz < duz:
            troco -= 200
            nduz += 1
        # Definir a quantidade de notas de 100
        while troco >= 100 and ncem < cem:
            troco -= 100
            ncem += 1
        # Definir a quantidade de notas de 50
        while troco >= 50 and nciq < ciq:
            troco -= 50
            nciq += 1
        # Definir a quantidade de notas de 10
        while troco >= 10 and nciq < dez:
            troco -= 10
            ndez += 1
        # Definir a quantidade de notas de 5
        while troco >= 5 and ncin < cin:
            troco -= 5
            ncin += 1
        # Definir a quantidade de moedas de 1
        while troco >= 1 and num < um:
            troco -= 1
            num += 1
        # Definir a quantidade de moedas de 0,50
        while troco >= 0.5 and ncents < cents:
            troco -= 0.5
            ncents += 1
        # Printar a quantidade de Cédulas utilizadas no troco
        if nduz > 0:
            print(f"{nduz} CÉDULA(s) DE 200".center(40))
        if ncem > 0:
            print(f"{ncem} CÉDULA(s) DE 100".center(40))
        if nciq > 0:
            print(f"{nciq} CÉDULA(s) DE 50".center(40))
        if ndez > 0:
            print(f"{ndez} CÉDULA(s) DE 10".center(40))
        if ncin > 0:
            print(f"{ncin} CÉDULA(s) DE 5 ".center(40))
        if num > 0:
            print(f"{num}  MOEDA(s) DE UM ".center(40))
        if ncents > 0:
            print(f"{ncents}  MOEDA(s) DE CINQUENTA".center(45))    

        
    # Somar o valor de todas e vendas e perguntar se deseja fechar o caixa
    valortotal = valor
    ans = input("Fechar o caixa? (S/N)")
    ans = ans.upper()

    # Fazer a repetição caso haja mais de 1 cliente
    while ans == 'N':
        # Inserção dos valores dos intens vendidos
        print("\nINSERÇÃO DOS ITENS VENDIDOS".center(40))
        n = float(input("Digite o valor do item 1: R$"))
        if n == 0:
          ans = input("Deseja Realmente Finalizar?? (S= Sim/N= Não)")
          ans = ans.upper()
          if ans == 'S':
              print(f"Venda Finalizada com 0 Item")
              exit()
          else:
              n = float(input(f"Digite o valor do item 1: R$"))
        # Definição dos valores bases das variaveis
        cont = 1
        valor = n
        valorantr = n
        # Repetição caso haja mais de 1 iten
        while n != 0:
            n = float(input(f"Digite o valor do item {cont+1}: R$"))
            # Desconsiderar o ultimo valor caso seja digitado -1
            if n == -1:
                if cont == 1:
                    valor = 0
                    n = float(input(f"Digite o valor correto do item {cont}: R$"))
                else:
                    valor -= valorantr
                    n = float(input(f"Digite o valor correto do item {cont}: R$"))
                cont -= 1
            # Finalizar a insesrção de valores quando inserido 0
            if n == 0:
                ans = input("Deseja Realmente Finalizar?? (S= Sim/N= Não)")
                ans = ans.upper()
                if ans == 'S':
                    print(f"Venda Finalizada com {cont} Itens\n")
                    break
                else:
                    n = float(input(f"Digite o valor do item {cont+1}: R$"))
            valor+=n
            valorantr = n
            cont+=1 
        print("\nVENDA FINALIZADA!!!")
        print(f"Valor Total: R${valor:.2f}")
        valorpago = float(input("Valor Pago: R$"))
        if valor == valorpago:
            print("NÃO HÁ TROCO")
        else:
            troco = (valorpago - valor)
            caixa -= troco
            print(f"Troco: R${troco:.2f}")
            # Definir a quantidade de notas de 200
            while troco >= 200 and nduz < duz:
                troco -= 200
                nduz += 1
            # Definir a quantidade de notas de 100
            while troco >= 100 and ncem < cem:
                troco -= 100
                ncem += 1
            # Definir a quantidade de notas de 50
            while troco >= 50 and nciq < ciq:
                troco -= 50
                nciq += 1
            # Definir a quantidade de notas de 10
            while troco >= 10 and nciq < dez:
                troco -= 10
                ndez += 1
            # Definir a quantidade de notas de 5
            while troco >= 5 and ncin < cin:
                troco -= 5
                ncin += 1
            # Definir a quantidade de moedas de 1
            while troco >= 1 and num < um:
                troco -= 1
                num += 1
            # Definir a quantidade de moedas de 0,50
            while troco >= 0.5 and ncents < cents:
                troco -= 0.5
                ncents += 1
            # Printar a quantidade de Cédulas utilizadas no troco]
            if nduz > 0:
                print(f"{nduz} CÉDULA(s) DE 200".center(40))
            if ncem > 0:
                print(f"{ncem} CÉDULA(s) DE 100".center(40))
            if nciq > 0:
                print(f"{nciq} CÉDULA(s) DE 50".center(40))
            if ndez > 0:
                print(f"{ndez} CÉDULA(s) DE 10".center(40))
            if ncin > 0:
                print(f"{ncin} CÉDULA(s) DE 5 ".center(40))
            if num > 0:
                print(f"{num}  MOEDA(s) DE UM ".center(40))
            if ncents > 0:
                print(f"{ncents}  MOEDA(s) DE CINQUENTA".center(45))    
            


        nc += 1
        valortotal += valor
        ans = input("Fechar o caixa? (S/N)")
        ans = ans.upper()

    # Printar o Fechamento do caixa
    print(f"\n{'Fechamento do Caixa!!!': >30}")
    print(f"Número de Clientes Atendidos: {nc}")
    print(f"Valor Total das Vendas: R${valortotal}")
    print(f"Valor existente no Caixa: {caixa}")
    if (duz - nduz) > 0:
        print(f"{duz - nduz} CÉDULA(s) DE 200".center(40))
    if (cem - ncem) > 0:
        print(f"{cem - ncem} CÉDULA(s) DE 100".center(40))
    if (ciq - nciq) > 0:
        print(f"{ciq - nciq} CÉDULA(s) DE 50".center(40))
    if (dez - ndez) > 0:
        print(f"{dez - ndez} CÉDULA(s) DE 10".center(40))
    if (cin - ncin) > 0:
        print(f"{cin - ncin} CÉDULA(s) DE 5 ".center(40))
    if (um - num) > 0:
        print(f"{um - num}  MOEDA(s) DE UM ".center(40))
    if (cents - ncents) > 0:
        print(f"{cents - ncents}  MOEDA(s) DE CINQUENTA".center(45))
    print("Até Breve................")
    