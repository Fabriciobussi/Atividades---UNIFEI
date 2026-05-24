#atividade3
arquivo = open("produtos.csv", "w")
arquivo.write("ID,Produto,Preço\n")
arquivo.write("1,Produto A,10.53\n")
arquivo.write("2,Produto B,20.79\n")
arquivo.write("3,Produto C,15.32\n")
arquivo.close()

print("CSV criado!")