
# def mostrar_numero():
#     print()
#     while (True):
#         try:
#             numero = float(input("Digite um número menor ou igual a 100: "))
#             if numero > 100:
#                 print("O número precisa ser menor ou igual a 100")
#                 continue
#             elif numero <= 0:
#                 print("O número precisa ser maior que 0")
#                 continue
#             else:
#                 print(f"Booaa... O número digitado foi {numero}")
#                 break
#         except:
#             print("Precisa ser um número")

# mostrar_numero()

def verificar_multiplos_de_2_e_3():
    print()
    while True:
        try:
            numero_digitado = int(input("Por gentileza, digite um número multiplo de 2 ou 3: "))
            if numero_digitado % 2 == 0 and numero_digitado % 3 == 0:
                print(f"Booaaa, você digito: {numero_digitado}, que é multiplo de 2 ou 3")
                break
            else:
                print(f"O número {numero_digitado} não é múltiplo de 2 nem de 3")
                continue
        except ValueError:
            print("O valor digitado não é um número")

verificar_multiplos_de_2_e_3()
