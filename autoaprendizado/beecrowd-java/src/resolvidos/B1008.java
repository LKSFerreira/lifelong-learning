package resolvidos;
import java.util.Scanner;

public class B1008 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            double numeroFuncionario = scanner.nextDouble();
            double horasTrabalhadas = scanner.nextDouble();
            double valorHoraTrabalhada = scanner.nextDouble();

            double salary = horasTrabalhadas * valorHoraTrabalhada;

            System.out.printf("NUMBER = %.0f\n", numeroFuncionario);
            System.out.printf("SALARY = U$ %.2f\n", salary);
        }
    }
}