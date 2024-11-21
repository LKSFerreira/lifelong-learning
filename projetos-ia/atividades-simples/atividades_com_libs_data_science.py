#pip install pandas matplotlib seaborn
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

# Leitura do arquivo Iris.csv
planta = pd.read_csv("Iris.csv")

# Função head(): exibe as 5 primeiras linhas do DataFrame
print(planta.head())
print("\n==========================================================================================\n")

# Função describe(): exibe informações estatísticas do DataFrame
# Contagem, média, desvio padrão, mínimo, 25%, 50%, 75% e máximo
print(planta.describe())
print("\n==========================================================================================\n")

# Função dtypes: exibe os tipos de dados de cada coluna
print(planta.dtypes)
print("\n==========================================================================================\n")

# Função shape: exibe a quantidade de linhas e colunas do DataFrame
# Retorna uma tupla (linhas, colunas)
print("(linhas, colunas)")
print(planta.shape)
print("\n==========================================================================================\n")

# Podemos renomear as colunas do DataFrame usando o atributo columns
planta.columns = ["id", "comprimento_sepala", "largura_sepala", "comprimento_petala", "largura_petala", "especie"]
print(planta.head())
print("\n==========================================================================================\n")

# É possível trabalhar com valores nulos no DataFrame por meio da função isnull()
# Por exemplo: Caso queiramos saber se há valores nulos em alguma coluna
coluna = "comprimento_sepala"
print("Valores nulos na coluna comprimento_sepala")
planta[planta[coluna].isnull()].head()
print("\n==========================================================================================\n")

# Para sabermos o total de cada classificação, podemos utilizar a função value_counts()
# Essa função retorna a quantidade de cada valor único em uma coluna
print("Quantidade de cada espécie")
print(planta["especie"].value_counts())
print("\n==========================================================================================\n")

# Para visualizar melhor os dados, com a lib matplotlib e seaborn podemos facilmente gerar gráficos
planta["especie"].value_counts().head(10).plot(kind='bar', figsize=(8, 4), grid=False, rot=0, color='orange')

# Podemos deixar o gráfico mais amigável com a função title() e xlabel()
plt.title("Quantidade de cada espécie") # Título do gráfico
plt.xlabel("Classificação") # Título do eixo x
plt.ylabel("Quantidade") # Título do eixo y
plt.show()

