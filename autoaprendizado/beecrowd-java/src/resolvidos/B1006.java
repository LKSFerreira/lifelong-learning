package resolvidos;
import java.util.Scanner;

public class B1006 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            double valorA = scanner.nextDouble();
            double valorB = scanner.nextDouble();
            double valorC = scanner.nextDouble();

            double pesoNotaA = 2;
            double pesoNotaB = 3;
            double pesoNotaC = 5;

            double media = ((valorA * pesoNotaA) + (valorB * pesoNotaB) + (valorC * pesoNotaC))
                    / (pesoNotaA + pesoNotaB + pesoNotaC);

            System.out.printf("MEDIA = %.1f\n", media);
        }
    }
}