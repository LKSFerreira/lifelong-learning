package resolvidos;
import java.util.Scanner;

public class B1041 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            String[] valores = scanner.nextLine().split(" ");
            double eixoX = Double.parseDouble(valores[0]);
            double eixoY = Double.parseDouble(valores[1]);

            if (eixoX == 0 && eixoY == 0) {
                System.out.println("Origem");
            } else if (eixoX == 0) {
                System.out.println("Eixo Y");
            } else if (eixoY == 0) {
                System.out.println("Eixo X");
            } else if (eixoX > 0 && eixoY > 0) {
                System.out.println("Q1");
            } else if (eixoX < 0 && eixoY > 0) {
                System.out.println("Q2");
            } else if (eixoX < 0 && eixoY < 0) {
                System.out.println("Q3");
            } else {
                System.out.println("Q4");
            }
        }
    }
}