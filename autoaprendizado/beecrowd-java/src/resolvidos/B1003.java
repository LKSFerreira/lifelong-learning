package resolvidos;
import java.util.Scanner;

public class B1003 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            
            int valorA = scanner.nextInt();
            int valorB = scanner.nextInt();

            int soma = valorA + valorB;

            System.out.println("SOMA = " + soma);
        }
    }
}