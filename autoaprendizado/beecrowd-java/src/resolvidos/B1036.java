package resolvidos;
import java.util.Scanner;

public class B1036 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            String[] valores = scanner.nextLine().split(" ");
            double A = Double.parseDouble(valores[0]);
            double B = Double.parseDouble(valores[1]);
            double C = Double.parseDouble(valores[2]);

            double delta = Math.pow(B, 2) - 4 * A * C;

            if (delta <= 0 || A == 0) {
                System.out.println("Impossivel calcular");
            } else {
                double raiz1 = (-B + Math.sqrt(delta)) / (2 * A);
                double raiz2 = (-B - Math.sqrt(delta)) / (2 * A);
                System.out.printf("R1 = %.5f\n", raiz1);    
                System.out.printf("R2 = %.5f\n", raiz2);
            }
        }
    }
}