'''3. Crie um algoritmo que receba do usuário um número qualquer e verifique se esse é
múl#plo de 5 e 7'''

n = int(input('Digite um numero:'))

if n % 5 and n % 7:
    print(n)
else: print('Esse numero nao eh multiplo de nenhum dos dois')