import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class UsoStream {
    public static void main(String[] args) {

        // * Classe Anônima
        // * Uma classe anônima é uma classe sem nome, que é tanto declarada e
        // * instanciada em uma unica expressão
        // * Deve-se considerar o uso de uma classe anônima sempre que você precisar
        // * criar uma classe que será usada apenas uma vezF

        // ? Functional Interface
        // ? Interface Funcional é uma interface que possui apenas um método abstrato
        // ? e, portanto, pode ser usada como um tipo para uma expressão lambda
        // ? Exemplos: Comparator, Consumer, Function, Predicate

        // ! Lambda
        // ! Uma expressão lambda é uma função anônima que você pode usar para criar
        // ! instâncias de uma interface funcional, não precisa colocar nome, tipo de
        // ! retorno e modificador de acesso
        // ! Exemplos: (x, y) -> x + y, (String s) -> s.length()

        // Method Reference - Referência de Método
        // Permite fazer referência a métodos ou construtores de uma classe (de forma
        // funcional) e indicar que dever ser utilizado num ponto específico do código
        // Deixando o código mais simples e legível. Para utilizar o Method Reference
        // basta utilizar o operador "::" e o nome do método que deseja fazer a
        // referência. Exemplos: System.out::println, String::length, Integer::parseInt
        // Forma para simplificar uma expressão lambda

        // * Stream API
        // * A Stream API traz novas opções para trabalhar com coleções em Java
        // * seguindo os princípios de programação funcional. Combinada com as
        // * expressões lambda, ela proporciona uma forma mais simples e concisa de
        // * escrever código, que aproveita melhor os recursos de processamento das
        // * máquinas atuais. Source -> Pipeline -> Terminal
        // * Exemplos: filter, map, sorted, collect

        // * Pipeline
        // * É uma sequência de operações que são executadas em uma coleção
        // * Source -> 0 ou mais operações intermediárias -> Terminal
        // * Exemplos: filter, map, sorted, collect

        // * Terminal
        // * É a operação final de um pipeline
        // * Exemplos: forEach, count, collect, reduce

        // * Collect
        // * É uma operação terminal que permite coletar os elementos de um stream e
        // * armazená-los em um container, como uma lista ou um set
        // * Exemplos: Collectors.toList(), Collectors.toSet()

        // * Collectors
        // * É uma classe utilitária que implementa várias funções de redução
        // * Exemplos: toList(), toSet(), toMap(), groupingBy(), joining()

        List<String> numerosAleatorios = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "8", "6", "5");

        System.out.println("Imprima todos os elementos dessa lista de String: ");

        numerosAleatorios.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                String linha = s + " ";
                System.out.print(linha);
            }
        });

        numerosAleatorios.forEach(System.out::println);
        System.out.println("---------------------------------------------");

        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set: ");

        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        var primeiros5Elementos = numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet());

        System.out.println(primeiros5Elementos);

        System.out.println("---------------------------------------------");

        System.out.println("Transforme esta lista de String em uma lista de números Inteiros: ");

        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(numerosAleatoriosInteger);

        System.out.println("---------------------------------------------");

        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista: ");

        var numeroPares = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> i % 2 == 0 && i > 2)
                .collect(Collectors.toList());

        System.out.println(numeroPares);

        System.out.println("---------------------------------------------");

        System.out.println("Mostre a média dos números: ");

        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("---------------------------------------------");

        System.out.println("Remova os valores ímpares: ");

        numerosAleatoriosInteger.removeIf(i -> i % 2 != 0);
        System.out.println(numerosAleatoriosInteger);

    }
}