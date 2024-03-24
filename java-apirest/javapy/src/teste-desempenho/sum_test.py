# .py
import time

def calculate_sum(n):
    return sum(range(1, n + 1))

# Defina o tamanho do teste
n = 1000000000

start_time = time.time()
total_sum = calculate_sum(n)
end_time = time.time()

print(f"Soma: {total_sum}")
print(f"Tempo de execução do Python: {end_time - start_time} segundos")