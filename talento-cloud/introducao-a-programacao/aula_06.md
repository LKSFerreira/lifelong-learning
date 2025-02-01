# Exceções em Python

As exceções em Python são usadas para lidar com erros que podem ocorrer durante a execução de um programa. Quando um erro ocorre, o Python normalmente para e gera uma mensagem de erro. No entanto, esses erros podem ser tratados usando o bloco `try/except`.

Estrutura básica:

```python
try:
    # Código que pode gerar um erro
except Exception as e:
    # Código que será executado se um erro ocorrer
```

No bloco `try`, você coloca o código que pode gerar um erro. No bloco `except`, você coloca o código que será executado se um erro ocorrer.

Por exemplo:

```python
try:
    print(1/0)  # Isso vai gerar um erro de divisão por zero
except Exception as e:
    print("Ocorreu um erro:", e)
```

Neste caso, como estamos tentando dividir por zero, um `ZeroDivisionError` será gerado. Como temos um bloco `except` para capturar a exceção, em vez de o programa parar, ele imprimirá "Ocorreu um erro: division by zero".

Você também pode ter múltiplos blocos `except` para lidar com diferentes tipos de erros:

```python
try:
    # Código que pode gerar um erro
except ZeroDivisionError:
    # Lidar com divisão por zero
except IndexError:
    # Lidar com índices fora do intervalo
except Exception as e:
    # Lidar com qualquer outro tipo de erro
```

Além disso, Python também fornece algumas palavras-chave adicionais que você pode usar com `try/except`:

- `else`: Este bloco de código será executado se nenhum erro ocorrer no bloco `try`.
- `finally`: Este bloco de código será executado independentemente de um erro ocorrer ou não.

Exemplo:

```python
try:
    print(1/1)  # Isso não vai gerar um erro
except Exception as e:
    print("Ocorreu um erro:", e)
else:
    print("Nenhum erro ocorreu.")
finally:
    print("Este código é executado independentemente de um erro ocorrer ou não.")
```

## Raise - Lançando Exceções Manualmente

Em Python, você pode usar a palavra-chave `raise` para lançar uma exceção manualmente. Isso é útil quando você quer interromper a execução do programa quando uma determinada condição é atendida.

Estrutura básica:

```python
raise Exception("Sua descrição aqui")
```

Por exemplo, digamos que você tenha uma função que aceita apenas números positivos. Você pode lançar uma exceção se um número negativo for passado:

```python
def sqrt(x):
    if x < 0:
        raise Exception("Não é possível calcular a raiz quadrada de um número negativo")
    else:
        return x ** 0.5
```

Neste exemplo, se você tentar chamar `sqrt(-1)`, o Python lançará uma exceção com a mensagem "Não é possível calcular a raiz quadrada de um número negativo".

## Múltiplo Try

No Python, não é possível ter vários blocos `try` seguidos por um único bloco `except`. Cada bloco `try` precisa de seu próprio bloco `except`. Se você quiser que cada chamada de função seja executada independentemente das outras, você precisará colocar cada uma em seu próprio bloco `try/except`.

```python
def calculadora(a, b, c):
    # Implementação da função vai aqui
    pass

try:
    print(calculadora(3, 0, 4))
except Exception as e:
    print(e)

try:
    print(calculadora(3, 2, 3))
except Exception as e:
    print(e)

try:
    print(calculadora(3, 2, 2))
except Exception as e:
    print(e)
```

Neste código, cada chamada para a função `calculadora` está dentro de seu próprio bloco `try/except`. Se um erro ocorrer ao chamar a função `calculadora`, o código dentro do bloco `except` correspondente será executado. Você precisará substituir o `pass` na função `calculadora` pela implementação real da função.

Exemplo corrigido em Python:

```python
try:
    print(calculadora(3, 0, 4))
    print(calculadora(3, 2, 3)) # Esta linha não será executada se um erro ocorrer na linha anterior
    print(calculadora(3, 2, 2)) # Esta linha não será executada se um erro ocorrer na linha anterior
except Exception as e:
    print(e)
```

Neste exemplo, todas as três chamadas para a função `calculadora` estão dentro do mesmo bloco `try`, e se um erro ocorrer em qualquer uma delas, o código dentro do bloco `except` será executado.

Mas se um erro ocorrer em qualquer chamada de função dentro do bloco `try`, a execução será interrompida e o controle será passado para o bloco `except` correspondente. As chamadas de função subsequentes no bloco `try` não serão executadas.

Se você quiser que cada chamada de função seja executada independentemente das outras, você precisará colocar cada uma em seu próprio bloco `try/except`.

Exemplo de como isso pode ser feito:

```python
for args in [(3, 0, 4), (3, 2, 3), (3, 2, 2)]:
    try:
        print(calculadora(*args))
    except Exception as e:
        print(e)
```

Neste exemplo, cada chamada para a função `calculadora` está em seu próprio bloco `try/except` dentro de um loop. Se um erro ocorrer em uma chamada de função, apenas essa chamada será afetada e as chamadas subsequentes ainda serão executadas.

Observação: O operador `*` é usado para desempacotar uma lista ou tupla em argumentos de função individuais. Por exemplo, `print(calculadora(*args))` é equivalente a `print(calculadora(3, 0, 4))`.

O asterisco (`*`) em Python é usado para desempacotar uma lista ou tupla em argumentos posicionais para uma função.

Quando existe um `*args` em uma definição de função, isso significa que a função pode aceitar qualquer número de argumentos posicionais. `args` é apenas uma convenção, você poderia usar qualquer nome que quiser. O importante é o asterisco (`*`).

Por exemplo, considere a seguinte função:

```python
def soma(*args):
    return sum(args)
```

Você pode chamar essa função com qualquer número de argumentos, e ela retornará a soma de todos eles:

```python
print(soma(1, 2, 3))  # Saída: 6
print(soma(1, 2, 3, 4, 5))  # Saída: 15
```
