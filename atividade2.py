#atividade2
arquivo = open("notas.txt", "a")
arquivo.write("João Aquino: 10\n")
arquivo.close()

arquivo = open("notas.txt", "r")
print(arquivo.read())
arquivo.close()