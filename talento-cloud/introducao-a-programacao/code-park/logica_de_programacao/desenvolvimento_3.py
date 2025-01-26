# 1. Usando o laço de repetição `for` em ordem crescente:
print()
for andar in range(1, 21):
    if andar == 13:
        continue
    print(andar)
print("=============\n")

# 2. Usando o laço de repetição `while` em ordem crescente:
andar = 1
while andar <= 20:
    if andar != 13:
        print(andar)
    andar += 1
print("=============\n")

# 3. Usando o laço de repetição `for` em ordem decrescente:
for andar in range(20, 0, -1):
    if andar == 13:
        continue
    print(andar)
print("=============\n")

# 4. Usando o laço de repetição `while` em ordem decrescente:
andar = 20
while andar > 0:
    if andar != 13:
        print(andar)
    andar -= 1
print("=============\n")
