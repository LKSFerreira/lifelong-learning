package resolvidos;
import java.util.Scanner;

public class B1038 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            String[] valores = scanner.nextLine().split(" ");
            int codigoPedido = Integer.parseInt(valores[0]);
            int quantidadePedido = Integer.parseInt(valores[1]);

            // cria um array com os valores dos produtos onde cada posição do array
            // representa o código do produto - 1, pois o array começa em 0
            double[] valorProduto = { 4.00, 4.50, 5.00, 2.00, 1.50 };

            // Calcula o valor a pagar

            double valorAPagar = valorProduto[codigoPedido - 1] * quantidadePedido;

            System.out.printf("Total: R$ %.2f\n", valorAPagar);
        }
    }
}