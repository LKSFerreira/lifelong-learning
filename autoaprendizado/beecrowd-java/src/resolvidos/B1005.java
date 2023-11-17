package resolvidos;
import java.util.Scanner;

public class B1005 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            double valorA = scanner.nextDouble();
            double valorB = scanner.nextDouble();

            double pesoNotaA = 3.5;
            double pesoNotaB = 7.5;

            double media = ((valorA * pesoNotaA) + (valorB * pesoNotaB)) / (pesoNotaA + pesoNotaB);

            System.out.printf("MEDIA = %.5f\n", media);
        }
    }
}