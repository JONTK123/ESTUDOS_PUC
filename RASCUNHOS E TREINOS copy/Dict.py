dict = {}
orgao = 'sacoleta'
v1 = 10
v2 = 20

dict[orgao] = [v1,v2]


for keys, values in dict.items():
    print(keys)
    print(values)

dict.update({'orguinho': 'xixi', 'pipi': 'coco'})
