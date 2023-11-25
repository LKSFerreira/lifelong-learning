# Maratona Java Virado no Jiraya

Melhor, maior, e o mais completo curso de Java em português grátis de toda Internet está de volta.
Maratona Java Virado No Jiraya. Regravado desde a aula 0, com extrema qualidade, utilizando a última versão do Java, com fonte 22 e fundo branco celestial.

Crétidos das aulas: [DevDojoBrasil](https://www.youtube.com/@DevDojoBrasilCanal)

"São mais de 250 aulas onde nós cobrimos praticamente o núcleo inteiro da linguagem. Desde o primeiro Olá mundo, até Orientação a Objetos, Coleções,  Conexão com banco de dados, Tratamento de exeções, Threads, Programação funcional e muito mais. Meu amigo... é aula para CARAMBA. Só não aprende Java quem não quer. Centenas de pessoas fizeram o curso anterior e conseguiram entrar no mercado de trabalho, imagina esse que é melhor, mais completo e atualizado."

___

[Vídeo Aula 00](https://youtu.be/VKjFuX91G5Q)
<details>
<summary><strong>Aula 00 - Maratona Java Virado No Jiraya - Bem-vindo</strong></summary>
Mostra sobre a ementa do curso, mostra a lista de todas as aulas, além de explicar que o curso foi todo regravado com a leitura dos comentários para saber as principais dúvidas dos viwers.
</details>

___

[Vídeo aula 01](https://youtu.be/ooCqalwSpuE)
<details>
<summary><strong>Aula 01 - O que esperar do curso</strong></summary>

O vídeo é mais um bate-papo sobre a caminhada como desenvolvedor Java, e como a barra de contratação do meu mercado de trabalho está aula. Além disso existe o mesmo curso em inglês para quem tiver interesse.
</details>

___

[Vídeo aula 02](https://youtu.be/JasmdiTyduI)
<details>
<summary><strong>Aula 02 - Como o Java Funciona</strong></summary>

Java é uma linguagem de programação orientada a objetos que funciona compilando o código-fonte em bytecode. Este bytecode é então compilado em código de máquina pela Máquina Virtual Java (JVM). O bytecode do Java pode ser executado em qualquer dispositivo que tenha a JVM, o que torna o Java uma linguagem "escreva uma vez, execute em qualquer lugar".

Processo resumido:

1. **Criação de um Programa Java**: O programa é escrito em Java, uma linguagem de programação de alto nível.
2. **Compilação do Programa Java**: O código-fonte Java é compilado em bytecode pelo compilador Java.
3. **Carregamento do Programa na Memória**: A JVM carrega o bytecode do programa na memória.
4. **Verificação do Bytecode**: A JVM verifica o bytecode para garantir que ele seja válido e seguro para executar.
5. **Execução do Programa**: A JVM executa o programa interpretando o bytecode em código de máquina.

</details>

___

[Vídeo aula 03](https://youtu.be/Tsyeybeh968)
<details>
<summary><strong>Aula 03 - Fazendo o download da JDK 15</strong></summary>
Java sendo uma linguagem de alto nível é amplamento padronizada, visto que o Java estava ficando para trás, fora decidido que as realeses seriam lançadas a cada 6 meses, dessa forma o Java consegue se manter relevante. O Java possui diversas versões, a mais utilizada é a LTS (Long Term Support).
</details>

___

[Vídeo aula 04](https://youtu.be/xzAESAp_soQ)
<details>
<summary><strong>Aula 04 - Configurando variaveis de ambiente</strong></summary>
Etapas para configurar a variável de ambiente JAVA_HOME no Windows:

1. **Localize o diretório de instalação do Java**: Se você não alterou o caminho durante a instalação do Java, ele será algo como `C:\Program Files\Java\jdk1.8.0_65`.

2. **Abra as Propriedades do Sistema**: Você pode fazer isso pressionando a tecla Windows + Pause/Break. No Windows XP, esse atalho abrirá diretamente as Propriedades do Sistema.

3. **Acesse as Configurações avançadas do sistema**: Clique em "Configurações avançadas do sistema".

4. **Abra as Variáveis de Ambiente**: Na aba "Avançado", clique em "Variáveis de Ambiente...".

5. **Crie a nova variável JAVA_HOME**: Em "Variáveis do sistema", clique em "Novo...". Digite o nome da variável como JAVA_HOME e no valor da variável, insira o caminho da instalação do Java (por exemplo, `C:\Program Files\Java\jdk1.8.0_65`) e clique em "OK".

6. **Adicione a variável JAVA_HOME à Path**: Localize a variável Path nas "Variáveis do sistema", selecione-a e clique em "Editar...". Vá ao início da "Valor da variável" e adicione o valor `%JAVA_HOME%\bin;` (sem as aspas) e clique em "OK".

7. **Verifique a configuração**: Abra o prompt de comando e digite `echo %JAVA_HOME%`. Deve aparecer o caminho especificado na variável. Caso não apareça, reinicie seu computador para processar as alterações.

</details>

___

[Vídeo aula 05](https://youtu.be/E64JTsEyXCM)
<details>
<summary><strong>Aula 05 - Executando compilação manualmente</strong></summary>

Para compilar e executar um programa Java "Olá, mundo!" manualmente:

1. **Escreva o código**: Primeiro, você precisa escrever o código Java. Exemplo de um programa "Olá, mundo!" em Java:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Olá, mundo!");
    }
}
```

2. **Salve o arquivo**: Salve este código em um arquivo chamado `Main.java`. Certifique-se de que o nome do arquivo corresponda ao nome da classe pública no seu código, poderia ser qualquer nome, contato que fosse o mesmo em public class {nome_do_arquivo}

3. **Abra o terminal**: Abra o terminal (ou prompt de comando) e navegue até o diretório onde você salvou seu arquivo `Main.java`.

4. **Compile o código**: No terminal, execute o seguinte comando para compilar seu código:

```bash
javac Main.java
```

Este comando compila seu código Java em bytecode. Se não houver erros no seu código, este comando criará um novo arquivo chamado `Main.class` no mesmo diretório.

5. **Execute o programa**: Agora você pode executar seu programa usando a Máquina Virtual Java (JVM). No terminal, execute o seguinte comando:

```bash
java Main
```

Este comando deve imprimir "Olá, mundo!" na tela. Obs: Não use a extensão para executar o probrama. Apenas o nome da classe precedido de `java`.
</details>

___

[Vídeo aula 06](https://youtu.be/uB5Qbm-RMyU)
<details>
<summary><strong>Aula 06 - Download da IDE IntelliJ Community</strong></summary>
O vídeo em questão trata sobre a instalação da IDE IntelliJ Community, além disso esta IDE possui uma versão paga chamada Ultimate, eu Lucas Ferreira particulamente tenho um apego muito grande ao VS Code (Visual Studio Code), apersar de que muitos não o consideram como uma IDE, eu diria que ele é o meio termo no qual podemos aproveitar o melhor de todos os mundos.
</details>

___

[Vídeo aula 07](https://youtu.be/ds3t9C2A50U)
<details>
<summary><strong>Aula 07 - Conhecendo a IDE IntelliJ Community</strong></summary>
Mostrou-se um pouco da IDE utilizada, além de demonstrar a instalação de alguns plugins/extensões, falou-se sobre convenções de nomenclatura no Java, como os padrões PascalCase para o uso de classe e camelCase para o uso de variáveis e métodos, além de entendermos que algumas palavras no Java são reservadas, ou seja, elas não podem ser utilizadas para nomeação. Além disso, a indentação é de extrema importância para a manutenção e legibilidade do código. O IntelliJ também melhora a produtividade do programador, pois existem muitos atalhos e autocompletar, além de verificar possíveis erros antes mesmo de compilar um projeto.
</details>

___

[Vídeo aula 08](https://youtu.be/TnnS-R--WKc)
<details>
<summary><strong>Aula 08 - Organizando o código em pacotes</strong></summary>
Para melhorar a organização de um projeto Java, trabalha-se com pacotes.

A convenção de nomenclatura de pacotes em Java é uma prática padrão que ajuda a evitar conflitos de nomes e organizar melhor o código:

1. **Nomes em minúsculas**: Os nomes dos pacotes são escritos em letras minúsculas para evitar conflitos com os nomes das classes ou interfaces.

2. **Uso do nome de domínio reverso**: As empresas usam o nome de seu domínio na Internet invertido para começar os nomes de seus pacotes. Por exemplo, para um pacote chamado "mypackage" criado por um programador em "example.com", o nome do pacote seria "com.example.mypackage".

3. **Prevenção de colisões de nomes**: As colisões de nomes que ocorrem dentro de uma única empresa precisam ser tratadas por convenção dentro dessa empresa, talvez incluindo a região ou o nome do projeto após o nome da empresa (por exemplo, "com.example.region.mypackage").

4. **Pacotes Java**: Os pacotes na própria linguagem Java começam com "java." ou "javax.".

5. **Nomes de domínio inválidos**: Em alguns casos, o nome do domínio da Internet pode não ser um nome de pacote válido. Isso pode ocorrer se o nome do domínio contiver um hífen ou outro caractere especial, se o nome do pacote começar com um dígito ou outro caractere que seja ilegal usar como o início de um nome Java, ou se o nome do pacote contiver uma palavra-chave reservada do Java, como "int". Nesse caso, a convenção sugerida é adicionar um sublinhado. Por exemplo: para o nome de domínio "hyphenated-name.example.org", o prefixo do nome do pacote seria "org.example.hyphenated_name".
</details>

___

[Vídeo aula 09](https://youtu.be/2rMT0qRyiYs)
<details>
<summary><strong>Aula 09 - Comentários</strong></summary>

1. Comentários de uma única linha: Esses comentários começam com duas barras para a frente (//). Qualquer texto entre // e o final da linha é ignorado pelo Java (não será executado). Eles são geralmente usados para descrições curtas.

Exemplo:
```java
// Este é um comentário
System.out.println("Olá, Mundo!");
```

2. Comentários de várias linhas: Esses comentários começam com /* e terminam com /. Qualquer texto entre / e */ será ignorado pelo Java. Eles são geralmente usados para descrições mais longas ou complexas.

Exemplo:
```java
/*
O código abaixo imprimirá as palavras Olá, Mundo na tela,
e isso é incrível
*/
System.out.println("Olá, Mundo!");
```

3. Comentários de documentação: Esses são comentários especiais que começam com /** e terminam com */. Eles são usados para produzir documentação API em HTML e são escritos antes das declarações de classe e método.

Exemplo:
```java
/**
 * Este método imprime na telas strings que são passadas como parâmetro
 * @param str - a string que será impressa na tela
 */
 */
public static void olaMundo(String fraseParaImprimir) {
    System.out.println(fraseParaImprimir);
}
```
</details>

___

[Vídeo aula 10](https://youtu.be/RRHGYyJTTpQ)
<details>
<summary><strong>Aula 10 - Tipos primitivos pt 01 - convenções de variáveis</strong></summary>
Existem oito tipos de dados primitivos:

* __byte:__ É um tipo de dado de 8 bits complemento de dois. Tem um valor mínimo de -128 e um valor máximo de 127 (inclusive).

* __short:__ É um tipo de dado de 16 bits complemento de dois. Tem um valor mínimo de -32,768 e um valor máximo de 32,767 (inclusive).

* __int:__ Por padrão, o tipo de dado int é um inteiro de 32 bits complemento de dois, que tem um valor mínimo de -2^31 e um valor máximo de 2^31 -1.

* __long:__ O tipo de dado long é um inteiro de 64 bits complemento de dois. O long assinado tem um valor mínimo de -2^63 e um valor máximo de 2^63 -1.

* __float:__ Armazena números fracionários. Suficiente para armazenar 6 a 7 dígitos decimais.

* __double:__ Armazena números fracionários. Suficiente para armazenar 15 dígitos decimais.

* __boolean:__ Armazena valores verdadeiros ou falsos.

* __char:__ Armazena um único caractere/letra ou valores ASCII2.

Esses tipos são chamados de primitivos porque eles são pré-definidos pela linguagem Java e são nomeados por uma palavra-chave reservada. Eles não compartilham estado com outros valores primitivos.

---

### As convenções de nomenclatura de variáveis em Java são as seguintes:

__Camel Case:__ As variáveis em Java devem começar com uma letra minúscula, e cada palavra subsequente deve começar com uma letra maiúscula. Por exemplo, myVariable.

__Nomes significativos:__ Os nomes das variáveis devem ser significativos e descrever o propósito da variável.

__Evite usar um caractere:__ Variáveis não devem ser nomeadas com um único caractere, como x, y, z, a menos que sejam usadas em loops pequenos.

__Nomes de constantes:__ As constantes em Java devem ser nomeadas em letras maiúsculas com palavras separadas por sublinhados (_). Por exemplo, MAX_VALUE.

São convenções e não regras rígidas, mas segui-las pode ajudar a manter seu código organizado, legível e evitar conflitos.
</details>

___


[Vídeo aula 11](https://youtu.be/veDgI_zZ7uk)
<details>
<summary><strong>Aula 11 - Tipos primitivos pt 02 - declaração e tamanho em memória</strong></summary>

```java
// byte: 1 byte
byte b = 100;
System.out.println("Valor do byte: " + b);

// short: 2 bytes
short s = 10000;
System.out.println("Valor do short: " + s);

// int: 4 bytes
int i = 100000;
System.out.println("Valor do int: " + i);

// long: 8 bytes
long l = 100000L;
System.out.println("Valor do long: " + l);

// float: 4 bytes
float f = 234.5f;
System.out.println("Valor do float: " + f);

// double: 8 bytes
double d = 123.4;
System.out.println("Valor do double: " + d);

// boolean: 1 byte
boolean bool = true;
System.out.println("Valor do boolean: " + bool);

// char: 2 bytes
char c = 'A';
System.out.println("Valor do char: " + c);
```
</details>

___

[Vídeo aula 12](https://youtu.be/74hd4o7V328)
<details>
<summary><strong>Aula 12 - Tipos primitivos pt 03 - casting</strong></summary>

No Java, existem dois tipos principais de casting:

* **Widening Casting (automático)**: É quando um tipo menor é convertido para um tipo maior. O Java faz isso automaticamente. Por exemplo, converter um `int` para um `double`:
```java
int myInt = 9;
double myDouble = myInt; // Casting automático: int para double
System.out.println(myInt); // Saída: 9
System.out.println(myDouble); // Saída: 9.0
```

* **Narrowing Casting (manual)**: É quando um tipo maior é convertido para um tipo menor. Isso deve ser feito manualmente, colocando o tipo entre parênteses na frente do valor¹²:
```java
double myDouble = 9.78d;
int myInt = (int) myDouble; // Casting manual: double para int
System.out.println(myDouble); // Saída: 9.78
System.out.println(myInt); // Saída: 9
```

No primeiro exemplo, o valor `int` é automaticamente convertido para `double`. No segundo exemplo, o valor `double` é manualmente convertido para `int`, e a parte decimal é truncada(perdida).

Lembre-se, o casting de alargamento não perde informações, mas o casting de estreitamento pode perder informações, pois você está tentando encaixar um tipo maior em um tipo menor.
</details>

___

[Vídeo aula 13](https://youtu.be/13VfcFXwsjw)
<details>
<summary><strong>Aula 13 - Tipos primitivos pt 04 - Strings</strong></summary>

`String` não é um tipo primitivo em Java. É uma classe, o que significa que é um tipo de referência. Embora seja frequentemente usado como se fosse um tipo primitivo, porque o Java fornece suporte especial para algumas operações de String (como o operador `+` para concatenação), na verdade é um objeto. Isso significa que ele tem métodos que você pode usar para realizar várias operações, como obter o comprimento da string, converter a string para maiúsculas ou minúsculas, e assim por diante.

Alguns detalhes importantes:

- **Imutabilidade**: As strings são constantes; seus valores não podem ser alterados depois de criados. Isso significa que quando você modifica uma String, você está realmente criando uma nova.

- **Métodos de String**: A classe String inclui métodos para examinar caracteres individuais da sequência, para comparar strings, para pesquisar strings, para extrair substrings e para criar uma cópia de uma string com todos os caracteres traduzidos para maiúsculas ou minúsculas.

- **Concatenação de String**: A linguagem Java fornece suporte especial para o operador de concatenação de string (`+`), e para a conversão de outros objetos em strings.

- **Representação Unicode**: Uma String representa uma string no formato UTF-16 em que caracteres suplementares são representados por pares substitutos.

Aqui estão alguns exemplos de como as strings podem ser usadas:

```java
// Criando uma string
String str = "Olá, Mundo!";

// Obtendo o comprimento de uma string
int length = str.length();

// Convertendo uma string para maiúsculas
String upper = str.toUpperCase();

// Procurando a primeira ocorrência de um texto em uma string
int index = str.indexOf("Mundo");
```

_Esses são apenas alguns exemplos das muitas operações que você pode realizar com Strings em Java._
</details>

___

[Vídeo aula 14](https://youtu.be/Q0REhCVBvAg)
<details>
<summary><strong>Aula 14 - Tipos primitivos pt 05 - Exercício</strong></summary>
Fora demonstrado alguns exemplos de exercícios para fixação do conteúdo.
</details>

___

[Vídeo aula 15](https://youtu.be/1Fsvlted69g)
<details>
<summary><strong>Aula 15 - Operadores pt 01 - Aritméticos</strong></summary>
Os operadores aritméticos em Java são usados para realizar operações matemáticas básicas. São eles:

1. **Adição (+)**: Este operador é usado para somar dois números. Por exemplo, `int soma = 3 + 2;` resultará em `soma` sendo `5`.

2. **Subtração (-)**: Este operador é usado para subtrair um número de outro. Por exemplo, `int subtracao = 3 - 2;` resultará em `subtracao` sendo `1`.

3. **Multiplicação (*)**: Este operador é usado para multiplicar dois números. Por exemplo, `int multiplicacao = 3 * 2;` resultará em `multiplicacao` sendo `6`.

4. **Divisão (/)**: Este operador é usado para dividir um número por outro. É importante notar que se ambos os números são inteiros, o resultado será um número inteiro. Por exemplo, `int divisao = 3 / 2;` resultará em `divisao` sendo `1`, não `1.5`. Se você quiser um resultado de ponto flutuante, pelo menos um dos números deve ser um número de ponto flutuante, como `double divisao = 3.0 / 2;` que resultará em `divisao` sendo `1.5`.

5. **Módulo (%)**: Este operador é usado para obter o resto de uma divisão. Por exemplo, `int modulo = 3 % 2;` resultará em `modulo` sendo `1`, porque quando `3` é dividido por `2`, o resto é `1`.

Exemplos:

```java
public class Main {
    public static void main(String[] args) {
        int a = 9;
        int b = 4;

        int soma = a + b;
        System.out.println("A soma é: " + soma); // A soma é: 13

        int subtracao = a - b;
        System.out.println("A subtração é: " + subtracao); // A subtração é: 5

        int multiplicacao = a * b;
        System.out.println("A multiplicação é: " + multiplicacao); // A multiplicação é: 36

        int divisao = a / b;
        System.out.println("A divisão é: " + divisao); // A divisão é: 2

        int modulo = a % b;
        System.out.println("O módulo é: " + modulo); // O módulo é: 1
    }
}
```
</details>

___

[Vídeo aula 16](https://youtu.be/U390IaCtOUk    )
<details>
<summary><strong>Aula 16 - Operadores pt 02 - Relacionais</strong></summary>
Os operadores relacionais em Java são usados para comparar dois valores. São eles:

1. **Maior que (>)**: Este operador é usado para verificar se um número é maior que outro. Por exemplo, `boolean maior = 3 > 2;` resultará em `maior` sendo `true`.

2. **Menor que (<)**: Este operador é usado para verificar se um número é menor que outro. Por exemplo, `boolean menor = 3 < 2;` resultará em `menor` sendo `false`.

3. **Igual a (==)**: Este operador é usado para verificar se dois valores são iguais. Por exemplo, `boolean igual = 3 == 2;` resultará em `igual` sendo `false`.

4. **Diferente de (!=)**: Este operador é usado para verificar se dois valores são diferentes. Por exemplo, `boolean diferente = 3 != 2;` resultará em `diferente` sendo `true`.

5. **Maior ou igual a (>=)**: Este operador é usado para verificar se um número é maior ou igual a outro. Por exemplo, `boolean maiorIgual = 3 >= 2;` resultará em `maiorIgual` sendo `true`.

6. **Menor ou igual a (<=)**: Este operador é usado para verificar se um número é menor ou igual a outro. Por exemplo, `boolean menorIgual = 3 <= 2;` resultará em `menorIgual` sendo `false`.

Exemplos:

```java
public class Main {
    public static void main(String[] args) {
        int a = 9;
        int b = 4;

        boolean maior = a > b;
        System.out.println("A é maior que B? " + maior); // A é maior que B? true

        boolean menor = a < b;
        System.out.println("A é menor que B? " + menor); // A é menor que B? false

        boolean igual = a == b;
        System.out.println("A é igual a B? " + igual); // A é igual a B? false

        boolean diferente = a != b;
        System.out.println("A é diferente de B? " + diferente); // A é diferente de B? true

        boolean maiorIgual = a >= b;
        System.out.println("A é maior ou igual a B? " + maiorIgual); // A é maior ou igual a B? true

        boolean menorIgual = a <= b;
        System.out.println("A é menor ou igual a B? " + menorIgual); // A é menor ou igual a B? false
    }
}
```
</details>

___

[Vídeo aula 17](https://youtu.be/cT6sw-Pw4l0)
<details>
<summary><strong>Aula 17 - Operadores pt 03 - Lógicos AND</strong></summary>
Os operadores lógicos em Java são usados para combinar duas ou mais expressões condicionais. Eles são fundamentais na construção de estruturas de controle complexas onde múltiplas condições precisam ser satisfeitas. São eles:

1. **E lógico (&&)**: Este operador retorna `true` se ambas as expressões condicionais forem verdadeiras. Por exemplo, `boolean eLogico = (5 > 3) && (2 < 4);` resultará em `eLogico` sendo `true`, porque ambas `(5 > 3)` e `(2 < 4)` são verdadeiras.

2. **OU lógico (||)**: Este operador retorna `true` se pelo menos uma das expressões condicionais for verdadeira. Por exemplo, `boolean ouLogico = (5 < 3) || (2 < 4);` resultará em `ouLogico` sendo `true`, porque pelo menos uma das expressões `(5 < 3)` ou `(2 < 4)` é verdadeira.

3. **NÃO lógico (!)**: Este operador inverte o valor da expressão condicional. Se a expressão for verdadeira, ele retorna `false` e vice-versa. Por exemplo, `boolean naoLogico = !(5 > 3);` resultará em `naoLogico` sendo `false`, porque `(5 > 3)` é verdadeiro, então o operador NÃO inverte para `false`.

Exemplo:

```java
public class Main {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;

        boolean eLogico = a && b;
        System.out.println("A e B? " + eLogico); // A e B? false

        boolean ouLogico = a || b;
        System.out.println("A ou B? " + ouLogico); // A ou B? true

        boolean naoLogico = !a;
        System.out.println("Não A? " + naoLogico); // Não A? false
    }
}
```
</details>

___

[Vídeo aula 18](https://youtu.be/ELcO4DN7lxw)
<details>
<summary><strong>Aula 18 - Operadores pt 04 - Lógico OR</strong></summary>
- Demonstrado tudo na aula 17.
</details>

___

[Vídeo aula 19]()
<details>
<summary><strong>Aula 19 - Operadores pt 05 - Atribuição</strong></summary>
Os operadores de atribuição em Java são usados para atribuir valores a variáveis. São eles:

1. **Atribuição (=)**: Este operador é usado para atribuir o valor à direita à variável à esquerda. Por exemplo, `int a = 5;` resultará em `a` sendo `5`.

2. **Adição e atribuição (+=)**: Este operador é uma forma abreviada de adicionar o valor à direita ao valor atual da variável e depois atribuir o resultado à variável. Por exemplo, `a += 3;` é equivalente a `a = a + 3;`.

3. **Subtração e atribuição (-=)**: Este operador é uma forma abreviada de subtrair o valor à direita do valor atual da variável e depois atribuir o resultado à variável. Por exemplo, `a -= 2;` é equivalente a `a = a - 2;`.

4. **Multiplicação e atribuição (*=)**: Este operador é uma forma abreviada de multiplicar o valor atual da variável pelo valor à direita e depois atribuir o resultado à variável. Por exemplo, `a *= 3;` é equivalente a `a = a * 3;`.

5. **Divisão e atribuição (/=)**: Este operador é uma forma abreviada de dividir o valor atual da variável pelo valor à direita e depois atribuir o resultado à variável. Por exemplo, `a /= 2;` é equivalente a `a = a / 2;`.

6. **Módulo e atribuição (%=)**: Este operador é uma forma abreviada de calcular o resto da divisão do valor atual da variável pelo valor à direita e depois atribuir o resultado à variável. Por exemplo, `a %= 2;` é equivalente a `a = a % 2;`.

Aqui está um exemplo de código que demonstra todos esses operadores:

```java
public class Main {
    public static void main(String[] args) {
        int a = 5;

        a += 3;
        System.out.println("A após adição e atribuição: " + a); // A após adição e atribuição: 8

        a -= 2;
        System.out.println("A após subtração e atribuição: " + a); // A após subtração e atribuição: 6

        a *= 3;
        System.out.println("A após multiplicação e atribuição: " + a); // A após multiplicação e atribuição: 18

        a /= 2;
        System.out.println("A após divisão e atribuição: " + a); // A após divisão e atribuição: 9

        a %= 2;
        System.out.println("A após módulo e atribuição: " + a); // A após módulo e atribuição: 1
    }
}
```
</details>

___

[Vídeo aula 20](https://youtu.be/gk1_Pn8GZA4)
<details>
<summary><strong>Aula 20 - Estruturas Condicionais pt 01 - IF</strong></summary>
As estruturas condicionais em Java são usadas para controlar o fluxo do programa com base em diferentes condições. Elas são a espinha dorsal de qualquer linguagem de programação e permitem que o programa tome decisões e execute diferentes blocos de código dependendo dessas decisões. 

1. **if**: A estrutura condicional `if` é a mais simples. Ela verifica se uma condição é verdadeira e, se for, executa um bloco de código. É importante lembrar que a condição dentro do `if` deve sempre retornar um valor booleano (`true` ou `false`). Por exemplo:

```java
int a = 5;
if (a > 3) {
    System.out.println("A é maior que 3"); // Esta linha será executada porque a condição é verdadeira
}
```

2. **else**: A estrutura condicional `else` é usada em conjunto com `if` para fornecer uma alternativa quando a condição `if` é falsa. O bloco de código dentro do `else` será executado se a condição `if` for falsa. Por exemplo:

```java
int a = 2;
if (a > 3) {
    System.out.println("A é maior que 3");
} else {
    System.out.println("A não é maior que 3"); // Esta linha será executada porque a condição if é falsa
}
```
</details>

___

[Vídeo aula 21](https://youtu.be/exxeNsgcg3c)
<details>
<summary><strong>Aula 21 - Estruturas Condicionais pt 02 - ELSE IF</strong></summary>
A condição `else if` 

1. **else if**: A estrutura condicional `else if` é usada para verificar várias condições em sequência. Se a condição `if` for falsa, ele verificará a próxima condição `else if`. Se todas as condições forem falsas, ele executará o bloco de código `else`. Isso é útil quando você tem várias condições que precisam ser verificadas em ordem. Por exemplo:

```java
int a = 2;
if (a > 3) {
    System.out.println("A é maior que 3");
} else if (a < 3) {
    System.out.println("A é menor que 3"); // Esta linha será executada porque a condição else if é verdadeira
} else {
    System.out.println("A é igual a 3");
}
```

1. **switch**: A estrutura condicional `switch` é usada para selecionar um dos muitos blocos de código para serem executados com base no valor de uma variável ou expressão. É uma alternativa ao uso de várias instruções `if-else if`. O `switch` avalia uma expressão e compara seu valor com cada caso (`case`). Se um caso corresponder, o bloco de código correspondente será executado. Se nenhum caso corresponder, o bloco de código `default` será executado (se houver). É importante lembrar de usar o comando `break` após cada caso para evitar que o código caia no próximo caso (isso é chamado de "fallthrough"). Por exemplo:

```java
int dia = 2;
switch (dia) {
    case 1:
        System.out.println("Segunda-feira");
        break;
    case 2:
        System.out.println("Terça-feira"); // Esta linha será executada porque dia é igual a 2
        break;
    // E assim por diante...
    default:
        System.out.println("Dia inválido");
}
```
</details>
___

[Vídeo aula 22](https://youtu.be/0ZQc0fXVJq4)
<details>
<summary><strong>Aula 22 - Estruturas Condicionais pt 03 - Operador ternário</strong></summary>

O operador ternário em Java é um operador condicional que fornece uma maneira mais curta e mais elegante de escrever instruções `if-else`. Ele é chamado de "ternário" porque envolve três operandos.

Sintaxe do operador ternário:

```java
variavel = (condicao) ? expressaoTrue : expressaoFalse;
```

- **condicao**: Esta é a expressão booleana que o operador ternário verifica. Se a condição for verdadeira, ele retorna `expressaoTrue`. Se for falsa, ele retorna `expressaoFalse`.
- **expressaoTrue**: Esta é a expressão que será avaliada e retornada se a condição for verdadeira.
- **expressaoFalse**: Esta é a expressão que será avaliada e retornada se a condição for falsa.

Exemplo:

```java
int a = 5;
int b = 3;

// Usando if-else
String resultado;
if (a > b) {
    resultado = "A é maior que B";
} else {
    resultado = "A não é maior que B";
}
System.out.println(resultado); // A é maior que B

// Usando operador ternário
resultado = (a > b) ? "A é maior que B" : "A não é maior que B";
System.out.println(resultado); // A é maior que B
```

Como podemos ver, o operador ternário permite escrever o mesmo código de uma maneira muito mais concisa. No entanto, deve ser usado com cuidado, pois pode tornar o código mais difícil de ler se usado excessivamente ou com condições complexas.
</details>

___

[Vídeo aula 23](https://youtu.be/Y3ODYE3npgo)
<details>
<summary><strong>Aula 23 - Estruturas Condicionais pt 04 - Tabela verdade e exercícios</strong></summary>
Exemplos de operadores lógicos em Java:

- **AND (&&)**: Retorna verdadeiro se ambas as expressões forem verdadeiras.
```java
boolean a = true;
boolean b = false;
System.out.println(a && b); // Imprime: false
```

- **OR (||)**: Retorna verdadeiro se pelo menos uma das expressões for verdadeira.
```java
boolean a = true;
boolean b = false;
System.out.println(a || b); // Imprime: true
```

- **NOT (!)**: Inverte o valor da expressão.
```java
boolean a = true;
System.out.println(!a); // Imprime: false
```
### Tabela verdade para os operadores lógicos AND, OR e NOT:

| A     | B     | A _AND_ B | A _OR_ B | _NOT_ A |
|-------|-------|---------|--------|-------|
| true  | true  | true    | true   | false |
| true  | false | false   | true   | false |
| false | true  | false   | true   | true  |
| false | false | false   | false  | true  |

- **A _AND_ B** é verdadeiro apenas quando **A** e **B** são ambos verdadeiros.
- **A _OR_ B** é verdadeiro se pelo menos um de **A** ou **B** é verdadeiro.
- **_NOT_ A** é o oposto de **A**. Se **A** for verdadeiro, então **NOT A** será falso e vice-versa.
</details>

___

[Video aula 24](https://youtu.be/W-ng6Dqa-E4)
<details>
<summary><strong>Aula 24 - Estruturas Condicionais pt 05 - Resolução dos exercícios</strong></summary>
Fora resolvido um exercício simples de estrutura condicional envolvendo o cálculo de imposto de renda.

Recomendo: https://www.beecrowd.com.br/judge/pt/problems/view/1051
</details>

___

[Vídeo aula 25](https://youtu.be/AYMtqJSrQTU)
<details>
<summary><strong>Aula 25 - Estruturas Condicionais pt 06 - Swicth</strong></summary>

A instrução `switch` em Java é usada para selecionar um dos muitos blocos de código a serem executados.

Exemplo simples:

```java
int dia = 4;
String nomeDoDia;

switch (dia) {
    case 1:
        nomeDoDia = "Domingo";
        break;
    case 2:
        nomeDoDia = "Segunda-feira";
        break;
    case 3:
        nomeDoDia = "Terça-feira";
        break;
    case 4:
        nomeDoDia = "Quarta-feira";
        break;
    case 5:
        nomeDoDia = "Quinta-feira";
        break;
    case 6:
        nomeDoDia = "Sexta-feira";
        break;
    case 7:
        nomeDoDia = "Sábado";
        break;
    default:
        nomeDoDia = "Dia inválido";
        break;
}

System.out.println(nomeDoDia); // Imprime: Quarta-feira
```

Neste exemplo, o valor da variável `dia` é comparado com os valores em cada `case`. Se o valor corresponder, o bloco de código correspondente é executado. Se nenhum valor corresponder, o bloco de código `default` é executado. A instrução `break` é usada para encerrar o bloco de código atual e sair da instrução `switch`. Se omitido, a execução continuará para o próximo `case`.
</details>

___

[Vídeo aula 26](https://youtu.be/GDAgMb9amow)
<details>
<summary><strong>Aula 26 - Estruturas Condicionais pt 07 - Switch exercício</strong></summary>
Fora resolvido um exercício simples de estrutura condicional envolvendo demonstração dos dias da semana.
</details>

___


