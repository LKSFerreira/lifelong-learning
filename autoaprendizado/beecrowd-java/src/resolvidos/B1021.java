package resolvidos;
import java.util.Scanner;

public class B1021 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            // Recebe um valor double do usuário e guarda esse valor na variável
            // valorInserido.
            double valorParaDecompor = scanner.nextDouble();

            // Guarda apenas a parte inteiro do valor double na variável valorNotas.
            int valorNotas = (int) (valorParaDecompor);

            // Para tabalhar com as moedas iremos subtrair o inserido do valor inteiro e
            // multiplicar por 100 para manipula-lo com inteiro.
            // Exemplo: R$250,57 - 250 = 0,57 // 0,57 * 100 // 57 -> Agora manipularemos a
            // parte decimal como um inteiro.

            // Lógica por tras da moeda

            // Ao multiplicar o um decimal por 100 podemos tratar o valor como inteiro.
            // Pense assim: Ao invez de ler uma como como 0,50 de Real, iremos ler ela como
            // 50 centavos.
            double moedasConvertidas = Math.floor((valorParaDecompor - valorNotas) * 100);

            // Remove todas as possíveis casa do número infinitéssimo gerado na manipulação
            // dos números.
            int valorMoedas = (int) moedasConvertidas;

            // Agora replicamos a lógica de cima em pequenos blocos dos valores que queremos
            // obter.

            // Obtem as notas de 100
            int notas100 = valorNotas / 100;
            valorNotas -= notas100 * 100;

            // Obtem as notas de 50
            int notas50 = valorNotas / 50;
            valorNotas -= notas50 * 50;

            // Obtem as notas de 20
            int notas20 = valorNotas / 20;
            valorNotas -= notas20 * 20;

            // Obtem as notas de 10
            int notas10 = valorNotas / 10;
            valorNotas -= notas10 * 10;

            // Obtem as notas de 5
            int notas5 = valorNotas / 5;
            valorNotas -= notas5 * 5;

            // Obtem as notas de 2
            int notas2 = valorNotas / 2;
            valorNotas -= notas2 * 2;

            // Obtem as notas de 1
            int moeda1 = valorNotas / 1;
            valorNotas -= moeda1 * 1;

            // Obtem as moedas de 50
            int moeda50 = valorMoedas / 50;
            valorMoedas -= (moeda50 * 50);

            // Obtem as moedas de 25
            int moeda25 = valorMoedas / 25;
            valorMoedas -= moeda25 * 25;

            // Obtem as moedas de 10
            int moeda10 = valorMoedas / 10;
            valorMoedas -= moeda10 * 10;

            // Obtem as moedas de 05
            int moeda05 = valorMoedas / 05;
            valorMoedas -= (moeda05 * 05);

            // Obtem as moedas de 1
            int moeda01 = valorMoedas / 1;
            valorMoedas -= moeda01 * 1;

            System.out.println("NOTAS:");
            System.out.println(notas100 + " nota(s) de R$ 100.00");
            System.out.println(notas50 + " nota(s) de R$ 50.00");
            System.out.println(notas20 + " nota(s) de R$ 20.00");
            System.out.println(notas10 + " nota(s) de R$ 10.00");
            System.out.println(notas5 + " nota(s) de R$ 5.00");
            System.out.println(notas2 + " nota(s) de R$ 2.00");
            System.out.println("MOEDAS:");
            System.out.println(moeda1 + " moeda(s) de R$ 1.00");
            System.out.println(moeda50 + " moeda(s) de R$ 0.50");
            System.out.println(moeda25 + " moeda(s) de R$ 0.25");
            System.out.println(moeda10 + " moeda(s) de R$ 0.10");
            System.out.println(moeda05 + " moeda(s) de R$ 0.05");
            System.out.println(moeda01 + " moeda(s) de R$ 0.01");
        }
    }
}