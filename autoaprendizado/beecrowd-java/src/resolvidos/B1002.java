package resolvidos;
import java.util.Scanner;

public class B1002 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            double raio = scanner.nextDouble();

            double area = 3.14159 * (raio * raio);

            System.out.printf("A=%.4f\n", area);

        }
    }
}
