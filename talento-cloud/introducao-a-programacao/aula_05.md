# Funçõe em Python

As funções em Python, e na maioria das linguagens de programação, são blocos de código que são projetados para fazer uma tarefa específica. Aqui estão as duas razões principais para usar funções:

1. **Evitar repetição**: Se houver um bloco de código que precisa ser executado várias vezes, você pode evitar a repetição colocando esse bloco de código em uma função e chamando a função sempre que precisar executar esse bloco de código.

2. **Encapsulamento**: Cada função é projetada para realizar uma tarefa específica. Encapsular essa tarefa em uma função ajuda a organizar o código, torna o código mais legível e mais fácil de manter.

---

- **Definindo uma Função**: Você pode definir uma função usando a palavra-chave `def`. Por exemplo:

  ```python
  def minha_funcao():
  print("Olá, Mundo!")
  ```

Esta função, quando chamada, imprimirá a string "Olá, Mundo!".

---

- **Chamando uma Função**: Depois de definir uma função, você pode chamá-la pelo nome. Por exemplo:

  ```python
  minha_funcao()
  ```

  Este código chama a função `minha_funcao` que definimos anteriormente, e imprimirá "Olá, Mundo!".

  ***

3. As funções em Python são compostas por três elementos principais:

   - **Nome da função**: O nome da função é como ela é identificada. É uma boa prática dar à função um nome que descreva a tarefa que ela realiza. Por exemplo, uma função que calcula a média de uma lista de números pode ser chamada de `calcular_media`.

   - **Parâmetros**: Os parâmetros são os valores que a função usa para realizar sua tarefa. Eles são especificados entre parênteses após o nome da função. Uma função pode ter qualquer número de parâmetros, desde nenhum até quantos você precisar. Por exemplo, a função `calcular_media` pode ter um parâmetro que é a lista de números.

   - **Retorno**: A palavra-chave `return` é usada para especificar o resultado que a função deve produzir. Quando a função é chamada, ela executa seu bloco de código e, em seguida, produz o valor especificado pela instrução `return`. Por exemplo, a função `calcular_media` pode retornar a média dos números na lista.

   ```python
   def calcular_media(numeros):
    soma = sum(numeros)
    media = soma / len(numeros)
    return media
   ```

   ```python
   lista_de_numeros = [1, 2, 3, 4, 5]
   print(calcular_media(lista_de_numeros))
   ```

   Neste exemplo, `calcular_media` é o nome da função, `numeros` é o parâmetro e a média dos números é o valor de retorno. A função é então chamada com `lista_de_numeros` como argumento, e o resultado é impresso.

## Simplificando a explicação

1. **Funções**:

```python
def minha_funcao(nome):
    return "Olá, " + nome

print(minha_funcao("Mundo"))
```

Este código define uma função `saudacao` que aceita um parâmetro `nome` e retorna uma string de saudação. Em seguida, chama a função com o argumento "Mundo".

---

2. **Parâmetros**: As funções podem receber parâmetros, que são valores que você pode passar para a função. Os parâmetros são definidos entre os parênteses na definição da função. Por exemplo:

```python
def minha_funcao(nome):
    print("Olá, " + nome)
```

---

Agora, quando chamamos `minha_funcao("Mundo")`, ela imprimirá "Olá, Mundo".

3. **Valores de Retorno**: As funções podem retornar valores usando a palavra-chave `return`. Por exemplo:

```python
def soma(a, b):
    return a + b
```

Agora, quando chamamos `soma(5, 3)`, a função retornará `8`.

---

4. **Multiplos valores de retorno**: As funções podem retornar vários valores separando-os com vírgulas. Por exemplo:

   ```python
   def antecessor_sucessor(x):
       return x-1, x+1

   antecessor, sucessor = antecessor_sucessor(5)
   print("Antecessor:", antecessor)
   print("Sucessor:", sucessor)
   ```

   Neste exemplo, a função `antecessor_sucessor` retorna dois valores: o antecessor e o sucessor do número fornecido. Quando chamamos a função com o número 5, atribuímos os valores de retorno às variáveis `antecessor` e `sucessor`, respectivamente. Em seguida, imprimimos esses valores, resultando em "Antecessor: 4" e "Sucessor: 6".

## Aprofundando

**Valores Padrão**: Você pode definir valores padrão para os parâmetros de uma função. Se um argumento para esse parâmetro não for fornecido ao chamar a função, o valor padrão será usado. Por exemplo:

```python
def minha_funcao(nome="Mundo"):
    print("Olá, " + nome)
```

Agora, se chamarmos `minha_funcao()` sem fornecer um nome, ela imprimirá "Olá, Mundo".

## Importante saber

Em Python, todas as funções retornam um valor, mesmo não sendo obrigatório o uso da palavra reservada `return`. Se nenhuma instrução de retorno for especificada, ou se a execução do código da função chegar ao fim sem atingir uma instrução de retorno, a função retornará `None` implicitamente. Isso é semelhante ao conceito de uma função "void" em outras linguagens de programação.

Aqui está um exemplo:

```python
def saudacao_lucas():
    print("Ola, Lucas!")

saudacao_lucas()
```

Neste exemplo, `saudacao_lucas` não tem uma instrução de retorno, mas implicitamente está devolveno `none`.

---

```python
def saudacao_lucas():
    print("Ola, Lucas!")

saudacao_lucas()

resultado = saudacao_lucas()
print(resultado)
```

Para provar isso, basta chamar a partir de uma variável que aguardará esse valor implicito.

Quando chamamos `saudacao_lucas` e imprimimos o resultado, veremos "Olá, Mundo!" seguido por "None".
