
import java.util.ArrayList;

public class lacos_de_repeticao {
    public static void main(String[] args) {
        // Laços de repetição em Java: for, while, do-while e foreach

        System.out.println("\n=== Laços de Repetição ===\n");

        // Exemplo 1: Laço for
        System.out.println("Laço for: Normalmente usado quando sabemos o número de iterações.");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Contador: " + i);
        }
        System.out.println();

        // Exemplo 2: Laço while
        System.out.println("Laço while: Normalmente usado quando não sabemos o número de iterações.");

        int j = 1;

        while (j <= 5) {
            System.out.println("Contador: " + j);
            j++;
        }

        System.out.println();

        // Exemplo 3: Laço do-while
        System.out.println("Laço do-while: Executa o bloco pelo menos uma vez antes de verificar a condição.");

        int k = 1;
        do {
            System.out.println("Contador: " + k);
            k++;
        } while (k <= 5);

        System.out.println();

        // Exemplo 4: Laço foreach (para arrays)
        System.out.println("Laço foreach (para arrays): Usado para iterar sobre elementos de um array ou coleção.");
        int[] numeros = { 10, 20, 30, 40, 50
        };

        for (int numero : numeros) {
            System.out.println("Número: " + numero);
        }

        System.out.println();

        ArrayList<String> frutas = new ArrayList<>();
        frutas.add("Maçã");
        frutas.add("Banana");
        frutas.add("Laranja");

        System.out.println(
                "Laço foreach (para ArrayList): Pode usado invocando o método forEach com uma expressão lambda.");

        frutas.forEach(fruta -> {
            System.out.println("Fruta: " + fruta);
        });

        System.out.println();

        // Exemplo 5: Uso de break e continue
        System.out.println("Uso de break e continue:");

        for (int m = 1; m <= 10; m++) {
            if (m == 6) {
                System.out.println("Interrompendo o laço quando m é igual a 6 (break).");
                break; // Interrompe o laço quando m é igual a 6
            }
            if (m % 2 == 0) {
                System.out.println("Pulando números pares (continue): " + m);
                continue; // Pula os números pares
            }
            System.out.println("Número ímpar: " + m);
        }

        System.out.println();

        // Observação: Sempre use chaves {} para delimitar blocos de código, mesmo que haja apenas uma linha dentro do bloco. Isso melhora a legibilidade e evita erros futuros.

        System.out.println("=== Fim dos exemplos de laços de repetição ===\n");

        System.out.println("=== Usando métodos de referência e streams ===\n");

        ArrayList<String> planetas = new ArrayList<>();
        planetas.add("Mercúrio");
        planetas.add("Vênus");
        planetas.add("Terra");
        planetas.add("Marte");
        planetas.add("Júpiter");
        planetas.add("Saturno");
        planetas.add("Urano");
        planetas.add("Netuno");

        System.out.println("Usando método de referência para imprimir planetas:");
        planetas.forEach(System.out::println);

        System.out.println();

        System.out.println("Usando outras referencias de métodos");

        planetas.forEach(String::toUpperCase);
        planetas.forEach(System.out::println);

        System.out.println();

        System.out.println("Usando streams para filtrar e imprimir planetas que começam com 'M':");

        planetas.stream()
                .filter(planeta -> planeta.startsWith("M"))
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Usando streams para imprimir o tamanho de cada nome de planeta:");

        planetas.stream()
                .map(String::length)
                .forEach(System.out::println);

    }
}
