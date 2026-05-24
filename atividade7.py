#atividade7
import pandas as pd

dados = {
    "Nome": ["Carlos", "Pedro", "Ana", "Fernanda"],
    "Idade": [25, 35, 28, 45],
    "Salário": [2500, 3500, 2800, 4200]
}

df = pd.DataFrame(dados)

print(df[df["Idade"] > 30])

print(df[df["Salário"] > 3000])
