import numpy as np
import pandas as pd

def gerar_dados_frutas():
    np.random.seed(42)  # Para resultados reproduzíveis
    
    # Parâmetros realistas para laranjas (valores em cm e gramas)
    laranjas = {
        'diâmetro': {
            'média': 7.5,   # Diâmetro médio de laranjas comerciais
            'desvio': 0.8,  # Variação típica
            'min': 6.0,     # Diâmetro mínimo comercial
            'max': 9.0      # Diâmetro máximo comercial
        },
        'peso': {
            'média': 150,   # Peso médio
            'desvio': 20,   # Variação comum
            'min': 100,     # Peso mínimo
            'max': 200      # Peso máximo
        }
    }
    
    # Parâmetros realistas para toranjas (valores em cm e gramas)
    toranjas = {
        'diâmetro': {
            'média': 10.5,  # Diâmetro médio de toranjas
            'desvio': 1.2,  # Variação maior que laranjas
            'min': 8.0,     # Diâmetro mínimo
            'max': 12.0     # Diâmetro máximo
        },
        'peso': {
            'média': 350,   # Peso médio
            'desvio': 40,   # Variação natural
            'min': 200,     # Peso mínimo
            'max': 400      # Peso máximo
        }
    }

    # Gerar 5000 laranjas
    dados_laranjas = pd.DataFrame({
        'diâmetro': np.clip(
            np.random.normal(
                loc=laranjas['diâmetro']['média'],
                scale=laranjas['diâmetro']['desvio'],
                size=5000
            ),
            laranjas['diâmetro']['min'],
            laranjas['diâmetro']['max']
        ).round(2),
        
        'peso': np.clip(
            np.random.normal(
                loc=laranjas['peso']['média'],
                scale=laranjas['peso']['desvio'],
                size=5000
            ),
            laranjas['peso']['min'],
            laranjas['peso']['max']
        ).round(2)
    })

    # Gerar 5000 toranjas
    dados_toranjas = pd.DataFrame({
        'diâmetro': np.clip(
            np.random.normal(
                loc=toranjas['diâmetro']['média'],
                scale=toranjas['diâmetro']['desvio'],
                size=5000
            ),
            toranjas['diâmetro']['min'],
            toranjas['diâmetro']['max']
        ).round(2),
        
        'peso': np.clip(
            np.random.normal(
                loc=toranjas['peso']['média'],
                scale=toranjas['peso']['desvio'],
                size=5000
            ),
            toranjas['peso']['min'],
            toranjas['peso']['max']
        ).round(2)
    })

    # Combinar e salvar os dados
    dados_completos = pd.concat([dados_laranjas, dados_toranjas], ignore_index=True)
    dados_completos.to_csv('dados_frutas.csv', index=False)
    print("Arquivo 'dados_frutas.csv' gerado com sucesso! (10.000 registros)")

if __name__ == "__main__":
    gerar_dados_frutas()