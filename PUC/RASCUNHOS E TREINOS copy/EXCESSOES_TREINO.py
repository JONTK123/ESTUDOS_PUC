#print(a)

'''try:
    print(a)
except NameError as erro: #erro virou variavel, variavel = erro
    print(' Voce digitou um erro', erro) 
except Exception as erro:
    print(' Erro inesperado')

print('Continuando...') #mesmo que de o erro ele continua o programa.'''

# O PROGRAMA vai devolver: Voce digitou um erro ( print 1 ) pois o erro caiu na excessao especifica do NameError e nao do Exception ( GERAL ) 

'''try:
    a = 1 
except NameError as erro: #erro virou variavel, variavel = erro, ERRO ESPECIFICO
    print(' Voce digitou um erro') 

except (IndexError, KeyError) as erro:
    print(' Erro de index ou chaves')

except Exception as erro: 
    print(' Erro inesperado')

else:
    print('Codigo foi um sucesso')
    print(a)

finally:
    print('Finalmente')'''


try:
    a = 1 
except NameError as erro: #erro virou variavel, variavel = erro, ERRO ESPECIFICO
    print(' Voce digitou um erro') 

except (IndexError, KeyError) as erro:
    print(' Erro de index ou chaves')

except Exception as erro: 
    print(' Erro inesperado')

else:
    pass

finally:
    a = None

print(a)