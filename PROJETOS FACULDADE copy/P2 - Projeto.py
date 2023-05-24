#import getpass
import oracledb

connection = oracledb.connect(
user="SYSTEM",
password="1212",
dsn="localhost/xe")

cursor = connection.cursor()

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

#Apresentação
print('-'*30)
print('Calculadora da qualidade do ar')
print('-'*30)
print('Como funciona o cálculo?\nO cálculo funciona da seguinte maneira: são solicitados os valores utilizados no cálculo original da qualidade do ar, de acordo com a Cetesb. Após isso, o pior parâmetro é selecionado e classifica a qualidade do ar entre as possíveis opções:\033[m\n\033[32mN1 - Boa\033[m\n\033[33mN2 - Moderada\033[m\n\033[34mN3 - Ruim\033[m\n\033[31mN4 - Muito ruim\033[m\n\033[35mN5 - Péssima\033[m')
print('\033[1mATENÇÃO: OS VALORES DEVEM ESTAR NAS UNIDADES DE MEDIDA DEFINIDAS PELO ORGÃO RESPONSÁVEL\033[m.')

#Variáveis definidas
indice = 0

#Buscar os os dados no banco
cursor.execute("SELECT AVG(pi) FROM gases")
result = cursor.fetchall()
for row in result:
    pi = row[0]
print(f"A média dos gases pi é: {pi:.2f}")

cursor.execute("SELECT AVG(pif) FROM gases")
result = cursor.fetchall()
for row in result:
    pif = row[0]
print(f"A média dos gases pif é: {pif:.2f}")

cursor.execute("SELECT AVG(oz) FROM gases")
result = cursor.fetchall()
for row in result:
    oz = row[0]
print(f"A média dos gases oz é: {oz:.2f}")

cursor.execute("SELECT AVG(co) FROM gases")
result = cursor.fetchall()
for row in result:
    co = row[0]
print(f"A média dos gases co é: {co:.2f}")

cursor.execute("SELECT AVG(nit) FROM gases")
result = cursor.fetchall()
for row in result:
    nit = row[0]
print(f"A média dos gases nit é: {nit:.2f}")

cursor.execute("SELECT AVG(enx) FROM gases")
result = cursor.fetchall()
for row in result:
    enx = row[0]
print(f"A média dos gases enx é: {enx:.2f}")

#Condições para definir a qualidade do ar e Avaliação da qualidade do ar e suas consequências
if pi > 250 or pif > 125 or oz > 200 or co > 15 or nit > 1130 or enx > 800:
    print('A qualidade do ar é \033[1;35mN5 - Péssima\033[m. Toda a população pode apresentar sérios riscos de manifestações de doenças respiratórias e cardiovasculares. Aumento de mortes prematuras em pessoas de grupos sensíveis.')
elif pi > 150 or pif > 75 or oz > 160 or co > 13 or nit > 320 or enx > 365:
    print('A qualidade do ar é \033[1;31mN4 - Muito ruim\033[m. Toda a população pode apresentar agravamento dos sintomas como tosse seca, cansaço, ardor nos olhos, nariz e garganta e ainda falta de ar e respiração ofegante. Efeitos ainda mais graves à saúde de grupos sensíveis (crianças, idosos e pessoas com doenças respiratórias e cardíacas).')
elif pi > 100 or pif > 50 or oz > 130 or co > 11 or nit > 240 or enx > 40:
    print('A qualidade do ar é \033[1;34mN3 - Ruim\033[m. Toda a população pode apresentar sintomas como tosse seca, cansaço, ardor nos olhos, nariz e garganta. Pessoas de grupos sensíveis (crianças, idosos e pessoas com doenças respiratórias e cardíacas) podem apresentar efeitos mais sérios na saúde.')
elif pi > 50 or pif > 25 or oz > 100 or co > 9 or nit > 200 or enx > 20:
    print('A qualidade do ar é \033[1;33mN2 - Moderada\033[m. Pessoas de grupos sensíveis (crianças, idosos e pessoas com doenças respiratórias e cardíacas) podem apresentar sintomas como tosse seca e cansaço. A população, em geral, não é afetada.')
else:
    print('A qualidade do ar é \033[1;32mN1 - BOA\033[m. Não há riscos para a saúde')


