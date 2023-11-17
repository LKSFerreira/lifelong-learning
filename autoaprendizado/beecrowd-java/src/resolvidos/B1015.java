package resolvidos;
import java.util.Scanner;

public class B1015 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            String[] planoP1 = scanner.nextLine().replace(",", ".").split(" ");
            String[] planoP2 = scanner.nextLine().replace(",", ".").split(" ");
            double valorX1 = Double.parseDouble(planoP1[0]);
            double valorY1 = Double.parseDouble(planoP1[1]);
            double valorX2 = Double.parseDouble(planoP2[0]);
            double valorY2 = Double.parseDouble(planoP2[1]);
            
            double distancia = Math.sqrt(Math.pow(valorX2 - valorX1, 2) + Math.pow(valorY2 - valorY1, 2));

            System.out.printf("%.4f\n", distancia);
        }
    }
}