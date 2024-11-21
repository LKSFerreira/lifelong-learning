import time

def somatoria_sem_matematica(n):
    soma = 0
    for i in range(1, n + 1):
        soma += i
    return soma

def somatoria_com_matematica(n):
    return (n * (n + 1)) // 2

def main():
    n = int(input("Digite um número: "))

    inicio = time.time()
    resultado = somatoria_sem_matematica(n)
    print("Resultado sem matemática:", resultado)
    print("Tempo sem matemática:", time.time() - inicio)
    
    print("-------------------------")

    inicio = time.time()
    resultado = somatoria_com_matematica(n)
    print("Resultado com matemática:", resultado)
    print("Tempo com matemática:", time.time() - inicio)

if __name__ == "__main__":
    main()