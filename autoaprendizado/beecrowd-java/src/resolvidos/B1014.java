package resolvidos;
import java.util.Scanner;

public class B1014 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            int distancia = scanner.nextInt();
            double combustivelGasto = scanner.nextDouble();

            double autonomia = distancia / combustivelGasto;

            System.out.printf("%.3f km/l\n", autonomia);
        }
    }
}