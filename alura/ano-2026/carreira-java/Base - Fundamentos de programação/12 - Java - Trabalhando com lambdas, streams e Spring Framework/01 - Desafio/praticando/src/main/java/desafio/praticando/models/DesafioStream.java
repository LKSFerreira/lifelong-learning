package desafio.praticando.models;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class DesafioStream {

        public static void executar() {
                System.out.println("\n--- MÓDULO 3: DESAFIOS DE STREAMS ---");

                // EXERCÍCIO 1
                List<Integer> numerosEx1 = Arrays.asList(1, 2, 3, 4, 5, 6);
                System.out.println("\n1. Números Pares:");

                numerosEx1.stream()
                                .filter(numero -> numero % 2 == 0)
                                .forEach(System.out::println);

                System.out.println("\n===================================");

                // EXERCÍCIO 2
                List<String> palavrasEx2 = Arrays.asList("java", "stream", "lambda");
                System.out.println("\n2. Palavras em Maiúsculo:");

                palavrasEx2.stream()
                                .map(palavra -> palavra.toUpperCase())
                                .forEach(System.out::println);

                // EXERCÍCIO 3
                List<Integer> numerosEx3 = Arrays.asList(1, 2, 3, 4, 5, 6);
                System.out.println("\n3. Ímpares x 2 e Coleta:");

                var imparesDobrados = numerosEx3.stream()
                                .filter(numero -> numero % 2 != 0)
                                .map(numero -> numero * 2)
                                .collect(Collectors.toList());

                System.out.println(imparesDobrados);

                // EXERCÍCIO 4
                List<String> palavrasEx4 = Arrays.asList("apple", "banana", "apple", "orange", "banana");
                System.out.println("\n4. Remover Duplicatas:");

                // Jeito Antigo como se faria antigamente
                HashSet<String> palavrasUnicas = new HashSet<>(palavrasEx4);
                palavrasUnicas.forEach(System.out::println);

                // Nova forma usando streams
                palavrasEx4.stream()
                                .distinct()
                                .forEach(System.out::println);

                // EXERCÍCIO 5
                List<List<Integer>> listaDeNumerosEx5 = Arrays.asList(
                                Arrays.asList(1, 2, 3, 4),
                                Arrays.asList(5, 6, 7, 8),
                                Arrays.asList(9, 10, 11, 12));
                System.out.println("\n5. FlatMap, Primos e Ordenação:");

                var numerosPossivelmentePrimos = listaDeNumerosEx5.stream()
                                .flatMap(lista -> lista.stream())
                                .filter(DesafioStream::isPrimo)
                                .sorted()
                                .collect(Collectors.toList());
                System.out.println(numerosPossivelmentePrimos);

                // EXERCÍCIO 6
                List<Pessoa> pessoasEx6 = Arrays.asList(
                                new Pessoa("Alice", 22),
                                new Pessoa("Bob", 17),
                                new Pessoa("Charlie", 19));
                System.out.println("\n6. Filtrar Pessoas > 18 e ordenar nomes:");

                pessoasEx6.stream()
                                .filter(pessoa -> pessoa.getIdade() > 18)
                                .sorted(Comparator.comparing(Pessoa::getNome))
                                .forEach(System.out::println);

                // EXERCÍCIO 7 e 8
                List<Produto> produtos = Arrays.asList(
                                new Produto("Smartphone", 800.0, "Eletrônicos"),
                                new Produto("Notebook", 1500.0, "Eletrônicos"),
                                new Produto("Teclado", 200.0, "Eletrônicos"),
                                new Produto("Cadeira", 300.0, "Móveis"),
                                new Produto("Monitor", 900.0, "Eletrônicos"),
                                new Produto("Mesa", 700.0, "Móveis"));
                System.out.println("\n7. Eletrônicos < 1000 ordenados:");

                produtos.stream()
                                .filter(produto -> produto.getCategoria().equals("Eletrônicos")
                                                && produto.getPreco() < 1000)
                                .sorted(Comparator.comparing(Produto::getNome))
                                .forEach(System.out::println);

                System.out.println("\n8. Top 3 Eletrônicos mais baratos:");

                produtos.stream()
                                .filter(produto -> produto.getCategoria().equals("Eletrônicos"))
                                .sorted(Comparator.comparing(Produto::getPreco))
                                .limit(3)
                                .forEach(System.out::println);
        }

        private static boolean isPrimo(Integer numero) {
                if (numero < 2)
                        return false;
                if (numero == 2)
                        return true;
                if (numero % 2 == 0)
                        return false;
                for (int i = 3; i <= Math.sqrt(numero); i += 2) {
                        if (numero % i == 0)
                                return false;
                }
                return true;
        }
}
