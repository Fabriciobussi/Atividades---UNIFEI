#atividade4
arquivo = open("produtos.csv", "r")
for linha in arquivo:
    print(linha)
arquivo.close()