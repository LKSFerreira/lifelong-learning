# import time
# contador = 1
# while True:
#     print(f"Regou a planta {contador} vez")
#     contador += 1
#     if contador == 7:
#         break
# print("=========================================")

# contador = 0
# while contador <= 7:
#     print(f"Regou a planta {contador} vez")
#     contador += 1
# print("=========================================")


# for contador in range(1, 8):
#     print(f"Regou a planta {contador} vez")
# print("=========================================")


# for contador in range(8):
#     print(f"Regou a planta {contador} vez")
# print("=========================================")


# for contador in range(1, 10):
#     time.sleep(2)
#     print(f"Regou a planta {contador} vez")

# print("=========================================")
# for contador in range(0, 7, 2):
#     print(f"Regou a planta {contador} vez")
# print("=========================================")

# for contador in range(7):
#     if contador % 2 == 0:
#         print(f"Regou a planta {contador} vez")

# print("=========================================")

# for contador in range(0, 7, 2):
#     if contador % 2 != 0:
#         continue
#     print(f"Regou a planta {contador} vez")

# print("=========================================")
# print("Jeito da Professora")
# print("=========================================")
# contador = 0
# while contador <= 7:
#     if contador % 2 != 0:
#         contador += 1
#         continue
#     print(f"Regou a planta {contador} vez")
#     contador += 1

# print("=========================================")
# print("Nosso jeito")
# print("=========================================")
# contador = 0
# while contador <= 7:
#     if contador % 2 == 0:
#         print(f"Regou a planta {contador} vez")
#     contador += 1

# for contador in range(7):
#     if contador == 3 or contador == 4 or contador == 5:
#         print(f"Regou a planta {contador} vez")

# for contador in range(7):
#     if contador in (3, 4, 5):
#         print(f"Regou a planta {contador} vez")

# for contador in range(7):
#     if contador > 2:
#         print(f"Regou a planta {contador} vez")

# for contador in range(7):
#     if contador >= 3:
#         print(f"Regou a planta {contador} vez")

# for contador in range(7):
#     if contador < 3:
#         continue
#     print(f"Regou a planta {contador} vez")

print("=========================================")
for contador in range(7):
    if contador != 2 and contador != 3:
        print(f"Regou a planta {contador} vez")
