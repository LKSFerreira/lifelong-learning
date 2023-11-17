package resolvidos;
import java.util.Scanner;

public class B1007 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            double valorA = scanner.nextDouble();
            double valorB = scanner.nextDouble();
            double valorC = scanner.nextDouble();
            double valorD = scanner.nextDouble();

            double media = (valorA * valorB) - (valorC * valorD);

            System.out.printf("DIFERENCA = %.0f\n", media);
        }
    }
}