import numpy as np
import pandas as pd
import time

# Gerar um grande conjunto de dados
data = np.random.rand(100000000)  # 100 milhões de pontos de dados

# Criar um DataFrame Pandas
df = pd.DataFrame(data, columns=['Values'])

# Definir um limiar
threshold = 0.5

start_time = time.time()

# Filtrar os dados
filtered_df = df[df['Values'] > threshold]

# Calcular a média dos valores filtrados
mean_value = filtered_df['Values'].mean()

end_time = time.time()

print(f"Média dos valores acima do limiar: {mean_value}")
print(f"Tempo de execução do Python com Pandas/NumPy: {end_time - start_time} segundos")