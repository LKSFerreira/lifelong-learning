## Resumo Didático: Variáveis, Operações, Funções e a Execução no Computador

Este resumo detalha como algoritmos são estruturados de forma lógica para que possam ser executados por computadores, abordando desde os conceitos básicos de variáveis e operações até a organização modular com funções e o funcionamento interno do hardware.

### 1\. Variáveis e Tipos de Dados: A Base dos Algoritmos

Para que um algoritmo funcione, ele precisa manipular informações. Essas informações são armazenadas em **variáveis**.

  - **O que é uma Variável?**
    Pode ser entendida como uma "caixa" na memória do computador que guarda um valor. Ela é chamada de "variável" porque o conteúdo dessa caixa pode mudar (variar) durante a execução do algoritmo.

      - **Exemplo:** No algoritmo do café, a `quantidade` de pó é uma variável, calculada a partir de outras duas: `quantidade = número de xícaras * colher`.

  - **Diferentes Tipos de Dados:**
    Algoritmos lidam com diferentes tipos de informação, cada um com suas características:

    1.  **Texto (String):** Sequências de caracteres, como a palavra `"coado"` para escolher um tipo de café.
    2.  **Número Inteiro:** Números sem casas decimais, como a temperatura de `90` graus ou `3` colheres de pó.
    3.  **Número Decimal (Float):** Números com casas decimais para maior precisão, como `90.5` graus.
    4.  **Booleano:** Um tipo de dado que só pode ter dois valores: `Verdadeiro` ou `Falso`. É fundamental para testar condições e tomar decisões.

### 2\. Operadores: As Ferramentas para Manipular Dados

Para trabalhar com as variáveis, utilizamos operadores. Eles são símbolos que executam ações específicas.

#### a) Operadores Aritméticos

Realizam cálculos matemáticos:

  - **Adição (`+`), Subtração (`-`), Multiplicação (`*`), Divisão (`/`)**
  - **Resto da Divisão (`%`):** Muito útil para lógicas como a de verificar se um número é par. Se `numero % 2` resultar em `0`, o número é par.

#### b) Operadores Relacionais

Servem para comparar valores. O resultado de uma operação relacional é **sempre** um valor booleano (`Verdadeiro` ou `Falso`).

  - `==` (Igual a): Compara se dois valores são iguais. Usa-se `==` para comparar e `=` para atribuir um valor a uma variável.
  - `!=` (Diferente de)
  - `>` (Maior que) e `<` (Menor que)
  - `>=` (Maior ou igual a) e `<=` (Menor ou igual a)

#### c) Operadores Lógicos (Conectivos)

São usados para combinar múltiplas condições, permitindo criar lógicas mais complexas.

  - **E (`AND`):** Retorna `Verdadeiro` somente se **todas** as condições forem verdadeiras.
      - *Exemplo:* Para dirigir, é preciso ter `idade >= 18` **E** `tem_carteira == Verdadeiro`.
  - **OU (`OR`):** Retorna `Verdadeiro` se **pelo menos uma** das condições for verdadeira.
      - *Exemplo:* Para ter desconto, basta ser `idade >= 60` **OU** `estudante == Verdadeiro`.
  - **NÃO (`NOT`):** Inverte o valor lógico de uma condição. `NÃO Verdadeiro` se torna `Falso`.
      - *Exemplo:* `se NÃO usuario_logado`, exibe "Faça login".

### 3\. O Ciclo de Vida de um Algoritmo: Entrada, Processamento e Saída

Todo algoritmo segue um ciclo fundamental de funcionamento, exemplificado pelo algoritmo de verificação de meia-entrada:

1.  **Entrada (Input):** É a fase de coleta de dados. O algoritmo solicita as informações de que precisa, como a idade do usuário e se ele é estudante. Esses dados são armazenados em variáveis.
2.  **Processamento:** Com os dados de entrada, o algoritmo executa suas instruções. Ele aplica as operações lógicas (`OU`) e relacionais (`idade < 18`) para testar as condições e as operações aritméticas (`preco_total / 2`) para calcular o valor final.
3.  **Saída (Output):** É a fase em que o algoritmo apresenta o resultado do seu processamento, como exibir a mensagem "Meia-entrada aplicada" e o valor final a ser pago.

É importante lembrar que o desenvolvimento de algoritmos é um ciclo: **testamos, avaliamos os resultados e ajustamos** o código conforme necessário para corrigir erros ou adicionar novas regras.

### 4\. Modularizando com Funções: Organizando o Código

Quando algoritmos se tornam complexos, podemos organizá-los em blocos menores e reutilizáveis chamados **funções**.

  - **O que é uma Função?**
    É um "mini algoritmo" que realiza uma tarefa específica. Ela recebe dados de entrada (parâmetros), processa-os e retorna um resultado (saída). O conceito é muito similar ao das funções matemáticas (`f(x) = ax + b`), onde `x` é a entrada e `f(x)` é a saída.

  - **Exemplo: Conversor de Temperatura**
    Em vez de ter todo o cálculo no corpo principal do algoritmo, podemos criar uma função:

    ```pseudocode
    // 1. Definição da Função
    funcao converterCparaF(celsius):
        retornar (celsius * 9 / 5) + 32

    // 2. Programa Principal
    exibir "Digite a temperatura em Celsius:"
    c = ler do usuário
    f = converterCparaF(c) // 3. Chamada da Função
    exibir "Temperatura em ºF: " + f
    ```

    Essa abordagem torna o código mais limpo, organizado e fácil de manter. Se precisássemos de outras conversões, bastaria criar outras funções.

### 5\. Como o Computador Executa os Algoritmos?

Um computador não entende nossa linguagem, mas sim sinais elétricos. Os programas que escrevemos (implementações de algoritmos) são traduzidos para essa linguagem de máquina. O modelo que explica como isso funciona é a **Arquitetura de Von Neumann**.

  - **Componentes Básicos do Computador:**

    1.  **Unidade de Entrada:** Dispositivos que inserem dados no sistema (teclado, mouse).
    2.  **Unidade de Saída:** Dispositivos que exibem os resultados (monitor, impressora).
    3.  **Unidade de Memória (RAM):** Armazena temporariamente tanto as **instruções** do programa quanto os dados (as **variáveis**).
    4.  **Unidade Central de Processamento (UCP ou CPU):** O "cérebro" do computador, responsável por executar as instruções. É dividida em duas partes:
          - **Unidade de Controle:** Gerencia o fluxo de informações, buscando instruções na memória e coordenando as outras partes do hardware.
          - **Unidade Lógico-Aritmética (ULA):** É onde as operações (aritméticas, relacionais e lógicas) são efetivamente realizadas.

  - **O Ciclo Completo:**
    A **Unidade de Controle** busca uma instrução na **Memória**, a envia para a **ULA** para ser executada, busca os dados necessários (variáveis) na **Memória**, e ao final, envia o resultado para uma **Unidade de Saída**.

**Programar**, portanto, é o ato de criar essas sequências de instruções (algoritmos) de forma que o computador possa entendê-las e executá-las para transformar dados de entrada em resultados de saída úteis.