# Estrutura de Controle de Fluxo em Python

4. **Estruturas de Controle de Fluxo**:

   - **`if`** é usada para testar uma condição específica. Se a condição for verdadeira, o bloco de código dentro da instrução `if` será executado. Por exemplo:

   ```python
   x = 10
   if x > 5:
       print("x é maior que 5")
   ```

   Este código verifica se `x` é maior que 5 e, se for, imprime "x é maior que 5".

   ***

   - **`if-else`**: É uma extensão da instrução `if` que permite especificar um bloco de código a ser executado se a condição for falsa. Por exemplo:

   ```python
   x = 10
   if x > 5:
       print("x é maior que 5")
   else:
       print("x não é maior que 5")
   ```

   Este código verifica se `x` é maior que 5 e, se for, imprime "x é maior que 5". Se `x` não for maior que 5, imprime "x não é maior que 5".

   ***

   - **if-elif-else** permite especificar várias condições a serem verificadas. O Python verificará as condições na ordem em que aparecem na instrução e executará o bloco de código da primeira condição verdadeira. Se nenhuma das condições `if` ou `elif` for verdadeira, o bloco de código `else` será executado. Por exemplo:

   ```python
   x = 10
   if x > 10:
       print("x é maior que 10")
   elif x == 10:
       print("x é igual a 10")
   else:
       print("x é menor que 10")
   ```

   Este código verifica se `x` é maior que 10, igual a 10 ou menor que 10 e imprime a condição correspondente.

   ***

   - **for**: Em Python é usada para iterar sobre uma sequência (que pode ser uma lista, uma tupla, um dicionário, um conjunto ou uma string) ou outros objetos iteráveis. Durante a execução do loop `for`, o valor é atribuído à variável e o bloco de código interno é executado. Por exemplo:

   ```python
   for i in range(5):
       print(i)
   ```

   Este código imprime os números de 0 a 4. A função `range(5)` gera uma sequência de números de 0 a 4, e o loop `for` itera sobre essa sequência.

   ***

   - **for com intervalo personalizado**: Você pode personalizar o intervalo da função `range()` especificando o valor inicial, o valor final e o passo (incremento). Por exemplo:

   ```python
   for i in range(5,10):
       print(i)
   ```

   Este código imprime os números de 5 a 9. A função `range(5,10)` gera uma sequência de números de 5 a 9, e o loop `for` itera sobre essa sequência.

   ***

   - **for com incremento personalizado**: Você pode personalizar ainda mais a função `range()` especificando um passo diferente de 1. Por exemplo:

   ```python
   for i in range(0,10, 2):
       print(i)
   ```

   Este código imprime os números de 0 a 8, incrementando de 2 em 2. A função `range(0,10, 2)` gera uma sequência de números de 0 a 8, incrementando de 2 em 2, e o loop `for` itera sobre essa sequência.

   ***

   - **while** Para os casos de repetição mais genéricos, onde não se sabe o número de iterações, utiliza-se o laço de repetição while:

   ```python
   import random
   numero = random.randint(2, 5)
   print(numero)
   while numero != 5:
    numero = random.randint(2, 5)
    print(numero)
   ```

   Este código gera e imprime números aleatórios entre 2 e 5. O loop while continua enquanto o número gerado não for 5. Quando o número 5 é gerado, o loop termina.

   #### Obs: Caso queira utilzar o laço while da mesma forma que o laço for, então é se faz necessário escrever o incremento manualmente

   ```python
   i = 0
   while i < 10:
    print(i)
    i += 1
   ```

   Este código imprime os números de 0 a 4. O loop `while` continua enquanto a condição `i < 5` for verdadeira.

   ***
