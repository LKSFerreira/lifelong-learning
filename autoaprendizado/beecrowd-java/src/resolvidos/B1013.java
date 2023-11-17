package resolvidos;
import java.util.Scanner;

public class B1013 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            String[] linha = scanner.nextLine().replace(",", ".").split(" ");
            double valorA = Double.parseDouble(linha[0]);
            double valorB = Double.parseDouble(linha[1]);
            double valorC = Double.parseDouble(linha[2]);

            double maiorAB = (valorA + valorB + Math.abs(valorA - valorB)) / 2;

            double maiorValor = (maiorAB + valorC + Math.abs(maiorAB - valorC)) / 2;

            System.out.printf("%.0f eh o maior\n", maiorValor);
        }
    }
}