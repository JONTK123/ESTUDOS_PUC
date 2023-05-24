'''Foram anotadas as idades e alturas de 30 alunos. Faça um Programa que determine
quantos alunos com mais de 13 anos possuem altura inferior à média de altura
desses alunos. Trabalhe com listas'''

'''idade = 0
altura = 0
treze = 0
nalunos = 0
alunocondicoes = 0
medialtura = 0
altura13 = 0

lista13 = [idade]
listaMedia = [altura]
listaAlunoCondicoes = [0]

for alunos in range(1,4): #sao 30 mas vsf

    idade = int(input('Digite a idade dos alunos: '))
    altura = int(input('Digite a altura desses alunos, em cm: '))

    if idade > 13:
        treze += 1
        altura13 += altura
        medialtura = altura13 / treze

        lista13.append(treze)
        listaMedia.append(medialtura)

    if idade > 13 and altura < medialtura:
        alunocondicoes += 1
        listaAlunoCondicoes.append(alunocondicoes)
        
print('Quantidade de alunos com mais de 13 anos é ( em listas ):'  , lista13[1:])
print('A media da quantidade de alunos com altura inferior a media da classe é ( em listas): '  , listaMedia[1:])
print('A quantidade de alunos que atendem as condições ( mais que 13 menor q altura media da turma ) ( em listas ) é: ', listaAlunoCondicoes[1:])

print( 'Quantidade de alunos com mais de 13 anos', treze)
print( 'A media da altura das pessoas da turma é: ' , medialtura)

print(' Quantidade de alunos que sao maiores de 13 e com altura inferior a media da classe: ' , alunocondicoes)'''

listaltura13 = []
listalunosMed = []
listaidade = []
listaltura = []
listalunoscond = []
alunoscond = 0


for i in range(30):

    listaidade.append(int(input('Digite a idade dos alunos: ')))
    listaltura.append(int(input('Digite a altura desses alunos, em cm: ')))

for j in range(len(listaidade)): #percorrer a lista de idade

    if listaidade[j] > 13: #analisa cada item da lista, se a idade digitada for > 13 logo:
        listaltura13.append(listaltura[j]) #enfia na lista de altura de alunos com idade > 13, as alturas digitadas ( conferido no if acima )

    media = sum(listaltura13) / len(listaltura) #soma de todas as alturas digitadas que sao > 13 anos // o total de alturas digitadas

print(' a media de altura é igual a: ', media )

for i in range(len(listaltura13)): #analisa cada item da lista das alturas dos alunos que tem > 13 anos

    if listaltura13[i] < media: #se na lista, a altura do aluno com > 13 anos for menor que a media de altura dos alunos no geral
        alunoscond += 1 #acrecenta mais um no contador da condição de alunos, > 13 anos e < media
        
print('Lista de altura dos alunos com idade > 13:\n'  , listaltura13[1:])


print('A quantidade de alunos que atendem as condições ( > 13 e < m) é:\n', alunoscond )
















