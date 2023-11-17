package resolvidos;
import java.util.Scanner;

public class B1010 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            double totalPagar = 0;

            for (int i = 0; i < 2; i++) {

                String[] linha = scanner.nextLine().replace(",", ".").split(" ");
                int numeroPeca = Integer.parseInt(linha[1]);
                double valorPeca = Double.parseDouble(linha[2]);
                totalPagar += numeroPeca * valorPeca;                
            }

            System.out.printf("VALOR A PAGAR: R$ %.2f\n", totalPagar);
        }
    }
}