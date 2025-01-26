def calculadora():
    while True:
        print("1: Soma")
        print("2: Subtração")
        print("3: Multiplicação")
        print("4: Divisão")
        print("0: Sair")
        operacao = input("Digite o número para a operação correspondente: ")

        if operacao == "0":
            break
        elif (operacao != "1" and operacao != "2" and operacao != "3" and operacao != "4"):
            print("Essa opção não existe\n")
            continue

        operacao = int(operacao)
        num1 = float(input("Digite o primeiro valor: "))
        num2 = float(input("Digite o segundo valor: "))

        if operacao == 1:
            resultado = num1 + num2
        elif operacao == 2:
            resultado = num1 - num2
        elif operacao == 3:
            resultado = num1 * num2
        elif operacao == 4:
            if num2 != 0:
                resultado = num1 / num2
            else:
                print("Erro: Divisão por zero\n")
                continue

        print(f"Resultado: {resultado}\n")


calculadora()
