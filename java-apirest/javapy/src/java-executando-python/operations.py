import sys

def do_math_operations(val1, val2):
    sum_result = val1 + val2
    diff_result = val1 - val2
    product_result = val1 * val2
    div_result = val1 / val2 if val2 != 0 else "Divisão por zero"
    return sum_result, diff_result, product_result, div_result

# Captura os argumentos de linha de comando (excluindo o nome do script)
args = sys.argv[1:]

# Converte argumentos para inteiros
val1 = int(args[0])
val2 = int(args[1])

# Realiza as operações
results = do_math_operations(val1, val2)

# Imprime os resultados
for result in results:
    print(result)