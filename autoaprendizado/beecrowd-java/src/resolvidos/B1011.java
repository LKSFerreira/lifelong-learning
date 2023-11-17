package resolvidos;
import java.util.Scanner;

public class B1011 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            double raio = scanner.nextDouble();
            double area = 4.0 / 3 * 3.14159 * Math.pow(raio, 3);

            System.out.printf("VOLUME = %.3f\n", area);
        }
    }
}