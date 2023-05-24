import oracledb

connection = oracledb.connect(
user="SYSTEM",
password="1212",
dsn="localhost/xe")

cursor = connection.cursor()

#Tela Menu

while True:
    print("{:^40}".format("Menu\n"))
    print("{:^40}".format("Sistema Qualidade Do Ar\n"))
    print("{:^40}".format("1. Adicionar Amostra"))
    print("{:^40}".format("2. Alterar Amostra"))
    print("{:^40}".format("3. Excluir Amostra"))
    print("{:^40}".format("4. Classificar A Média Das Amostras"))
    print("{:^40}".format("5. Sair\n"))

    i = int(input("Digite O Número Da Opção Que Deseja Acessar: ")) # Excessões

    if i == 1:
        while True:
            print("{:^40}".format("Adicionar\n"))
            print("{:^40}".format("Sistema Qualidade Do Ar\n"))
            pi = float(input("{:^40}".format("Digite O Valor De MP10:")))
            pif = float(input("{:^40}".format("Digite O Valor De MP25:")))
            oz = float(input("{:^40}".format("Digite O Valor De O3:")))
            co = float(input("{:^40}".format("Digite O Valor De CO:")))
            nit = float(input("{:^40}".format("Digite O Valor De N2:")))
            enx = float(input("{:^40}".format("Digite O Valor De SO2:")))
            cursor.execute(f"INSERT INTO gases (pi,pif,oz,co,nit,enx) VALUES({pi}, {pif}, {oz}, {co}, {nit}, {enx})")
            connection.commit()
            i = 0
            print("-"*40)
            break

    '''if i == 2:
        while True:
            print("{:^40}".format("Alterar\n"))
            print("{:^40}".format("Sistema Qualidade Do Ar\n"))'''












    if i == 5:
        break