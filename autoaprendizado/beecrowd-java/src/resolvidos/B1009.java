package resolvidos;
import java.util.Scanner;

public class B1009 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            //String nomeVendedor = scanner.next();
            double salarioVendedor = scanner.nextDouble();
            double totalVendas = scanner.nextDouble();

            double comissaoPorcentagem = 0.15;

            double salary = salarioVendedor + (totalVendas * comissaoPorcentagem);

            System.out.printf("TOTAL = R$ %.2f\n", salary);
        }
    }
}