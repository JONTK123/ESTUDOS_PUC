'''A prefeitura de uma cidade fez uma pesquisa entre seus habitantes, coletando dados
sobre o salário e número de filhos. A prefeitura deseja saber: '''

'''a. média do salário da população;
b. média do número de filhos;
c. maior salário;
d. percentual de pessoas com salário até R$100,00. '''

FilhosAcumulador = 0
salarioAcumulador = 0
maior = 0
salarioMinimo = 0
PorcentSalarioMinimo = 0

nFor1 = int(input('Digite o numero de Habitantes para anlizar, media salarial e media de filhos: '))

for i in range(nFor1):
    nsalario = int(input('DIGITE O VALOR DO SALARIO:'))
    salarioAcumulador += nsalario
    nFilhos = int(input('Digite a quantidade de filhos produzidos: '))
    FilhosAcumulador += nFilhos

    if nsalario > maior:
        maior = salarioAcumulador

    if nsalario <= 100:
        salarioMinimo += 1 
    
PorcentSalarioMinimo = ( salarioMinimo * 100 / nFor1) 
    
mediaSalario = salarioAcumulador / nFor1
mediaFilhos = FilhosAcumulador / nFor1

print('Media de salario é: ',mediaSalario)
print('Media de filhos é: ', mediaFilhos)

print('Maior salario é:', maior)
print('Quantidade de pessoas com salario menor = 100 em % é:', PorcentSalarioMinimo)















    



