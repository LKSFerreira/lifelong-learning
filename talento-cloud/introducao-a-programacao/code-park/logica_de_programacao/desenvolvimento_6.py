def calcular_idade():
    nome = input("Digite seu nome completo: ")
    while True:
        try:
            ano_nascimento = int(input("Digite seu ano de nascimento (entre 1922 e 2021): "))
            if 1922 <= ano_nascimento <= 2023:
                idade = 2023 - ano_nascimento
                print(f"Olá, {nome}! Você completou, ou completará, {idade} anos em 2022.")
                break
            else:
                raise Exception("O ano de nascimento deve estar entre 1922 e 2021. Tente novamente.")
        except ValueError:
            print("Erro: Você deve digitar um número para o ano de nascimento. Tente novamente.")
        except Exception as e:
            print(e)


calcular_idade()

# Este programa pede ao usuário para inserir seu nome completo e ano de nascimento.
# Se o ano de nascimento for um número entre 1922 e 2023, o programa calculará a idade do usuário em 2023 e imprimirá uma mensagem com essa informação.
# Se o ano de nascimento não for um número ou estiver fora do intervalo permitido, o programa imprimirá uma mensagem de erro e pedirá ao usuário para tentar novamente.
