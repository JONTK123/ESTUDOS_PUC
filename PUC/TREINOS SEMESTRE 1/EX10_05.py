# JOAO PEDRO GIARETTA RA:23008717
# ENZO CINTO QUATROCHI RA:23015904

voos = {}

while True:
    try:
        n = int(input("Digite a quantidade de voos que deseja inserir: "))
        break
    except ValueError:
        print("Digite um numero inteiro")

for i in range(n):
    cod_voo = int(input("Digite o Código do Voo: "))
    city_origem = input("Digite a cidade de origem: ").title()
    city_destino = input("Digite a cidade de destino: ").title()
    num_escalas = int(input("Digite o numero de escalas: "))

    if num_escalas > 0:
        city_escala = []
        for i in range(num_escalas):
            city = input("Digite o nome da cidade da escala: ").title()
            city_escala.append(city)
        voos[cod_voo] = [city_origem, city_destino, num_escalas, city_escala]
    else: 
        voos[cod_voo] = [city_origem, city_destino, num_escalas]

print(voos)

#Alterar informações
while True:
    try:
        key = int(input("Digite o código do voo que deseja alterar as informações: "))
        break
    except ValueError:
        print("Digite um numero inteiro")

if key in voos.keys():
    new_city_origem = input("Digite a cidade de origem: ").title()
    new_city_destino = input("Digite a cidade de destino: ").title()
    new_num_escalas = int(input("Digite o numero de escalas: "))
    if new_num_escalas > 0:
        new_city_escala = []
        for i in range(new_num_escalas):
            city = input("Digite o nome da cidade da escala: ").title()
            new_city_escala.append(city)
        voos[key] = [new_city_origem, new_city_destino, new_num_escalas, new_city_escala]
    else: 
        voos[key] = [new_city_origem, new_city_destino, new_num_escalas]
    print(voos[key])

#Apagar um voo
while True:
    try:
        key = int(input("Digite o código do voo que deseja apagar: "))
        voos.pop(key)
        break
    except ValueError:
        print("Digite um numero inteiro")

#Dada a cidade origem, determinar quantos voos saem dessa cidade
city = input("Digite a cidade de origem que deseja saber os voos: ").title()
n = 0
for values in voos.values():
    if values[0] == city:
        n +=1
if n > 0:
    print(f"A quantidade de voos saindo dessa cidade é {n}")
else:
    print("Não Há voos saindo dessa cidade")

#Dada a cidade origem e destino, determinar o voo com menor número de escalar e imprimir todas as informações sobre esse voo
city_org = input("Digite a cidade de origem: ").title()
city_dest = input("Digite a cidade de destino: ").title()
menor = 100

for keys, values in voos.items():
    if values[0] == city_org and values[1] == city_destino:
        if values[2] < menor:
            menor = values[2]
            result = keys,values
        else: 
            result = ("Não há voos entre essas cidades")
print(result)
