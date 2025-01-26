# Faça uma função calculadora de dois números com três parâmetros: os dois primeiros serão os números da operação e o terceiro será a entrada que definirá a operação a ser executada. Considera a seguinte definição:
# 1. Soma
# 2. Subtração
# 3. Multiplicação
# 4. Divisão

def calculadora(num1, num2, operacao):
    if operacao == 1:
        return num1 + num2
    elif operacao == 2:
        return num1 - num2
    elif operacao == 3:
        return num1 * num2
    elif operacao == 4:
        if num2 != 0:
            return num1 / num2
        else:
            return "Erro: Divisão por zero"
    else:
        return 0


print(calculadora(3, 2, 1))
print(calculadora(3, 2, 2))
print(calculadora(3, 2, 3))
print(calculadora(3, 2, 4))

