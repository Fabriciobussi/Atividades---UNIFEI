#atividade5
entrada = open("produtos.csv", "r")
saida = open("produtos_desconto.csv", "w")

primeira_linha = True
for linha in entrada:
    if primeira_linha:
        saida.write(linha)
        primeira_linha = False
    else:
        partes = linha.strip().split(",")
        preco = float(partes[2])
        preco_desconto = preco * 0.9
        saida.write(partes[0] + "," + partes[1] + "," + str(round(preco_desconto, 2)) + "\n")

entrada.close()
saida.close()
print("Arquivo com desconto criado!")
