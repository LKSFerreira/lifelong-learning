import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from matplotlib import rcParams
import seaborn as sns

# Aplica uma estilização para os gráficos
plt.style.use('ggplot')
rcParams['figure.figsize'] = 12, 8

# .head() para visualizar as primeiras linhas do dataset, por padrão são 5 linhas
# .tail() para visualizar as últimas linhas do dataset, por padrão são 5 linhas

# Carrega o dataset
df = pd.read_csv("carros_usados.csv")

# Exibe as primeiras linhas do dataset
print("(linha, coluna)")
print(df.head())
print("===========================================================================================================\n")

# Exibe as últimas linhas do dataset
print(df.tail())
print("===========================================================================================================\n")

# .shape para visualizar a quantidade de linhas e colunas do dataset
print(df.shape)
print("===========================================================================================================\n")

# .info() para visualizar informações sobre o dataset, como quantidade de valores nulos e tipo de dados
print(df.info())
print("===========================================================================================================\n")

# .describe() para visualizar informações estatísticas sobre o dataset
print(df.describe())
print("===========================================================================================================\n")

# .columns para visualizar as colunas do dataset
print(df.columns)
print("===========================================================================================================\n")

# .isnull().sum() para visualizar a quantidade de valores nulos em cada coluna
print(df.isnull().sum())
print("===========================================================================================================\n")

# .nunique() para visualizar a quantidade de valores únicos em cada coluna
print(df.nunique())

