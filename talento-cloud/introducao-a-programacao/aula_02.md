# Variáveis em Python

São locais de armazenamento onde você pode guardar valores para usar e manipular mais tarde em seu programa.

1. **Declaração de Variáveis**: Em Python, as variáveis não precisam ser declaradas ou definidas com antecedência. Para criar uma variável, você apenas atribui um valor a ela. Por exemplo:

```python
x = 10
mensagem = "Olá, Mundo!"
```

Neste exemplo, `x` é uma variável do tipo `int` e `mensagem` é uma variável do tipo `str`.

2. **Tipagem Dinâmica**: Python é uma linguagem de tipagem dinâmica. Isso significa que o tipo de uma variável é determinado no momento da execução (ou seja, em tempo de execução). Portanto, você pode atribuir um valor de um tipo a uma variável e, em seguida, atribuir um valor de outro tipo à mesma variável. Por exemplo:

```python
x = 10
x = "Olá, Mundo!"
```

Neste exemplo, `x` é inicialmente um `int`, mas se torna um `str` após a segunda atribuição.

3. **Nomes de Variáveis**: Os nomes das variáveis em Python podem conter letras, números e sublinhados (\_), mas não podem começar com um número. Além disso, Python diferencia maiúsculas de minúsculas, então `variavel`, `Variavel` e `VARIavel` seriam três nomes de variáveis diferentes.

4. **Atribuição Múltipla**: Python permite a atribuição múltipla, o que permite que você atribua valores a várias variáveis ao mesmo tempo. Por exemplo:

```python
x, y, z = "Olá", "Mundo", 123
```

Neste exemplo, `x` recebe o valor "Olá", `y` recebe o valor "Mundo" e `z` recebe o valor 123.
