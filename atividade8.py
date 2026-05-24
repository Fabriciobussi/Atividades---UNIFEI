#atividade8
import pandas as pd

dados = {
    "Nome": ["João", "Maria", "José"],
    "Idade": [28, 34, 29],
    "Cidade": ["São Paulo", "Rio de Janeiro", "Curitiba"]
}

df = pd.DataFrame(dados)
df.to_csv("dados.csv", index=False)

df2 = pd.read_csv("dados.csv")
print(df2)