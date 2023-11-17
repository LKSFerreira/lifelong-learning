import java.util.Scanner;

public class B1051 {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            double salario = Double.parseDouble(scanner.nextLine());

            if (salario <= 2000) {
                System.out.println("Isento");
            } else if (salario <= 3000) {
                double impostoIcidente = (salario - 2000) * 0.08;
                System.out.printf("R$ %.2f\n", impostoIcidente);
            } else if (salario <= 4500) {
                double impostoIcidente = (salario - 3000) * 0.18 + 1000 * 0.08;
                System.out.printf("R$ %.2f\n", impostoIcidente);
            } else {
                double impostoIcidente = (salario - 4500) * 0.28 + 1500 * 0.18 + 1000 * 0.08;
                System.out.printf("R$ %.2f\n", impostoIcidente);
            }
        }
    }
}
