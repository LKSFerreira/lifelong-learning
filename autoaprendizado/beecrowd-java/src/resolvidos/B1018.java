package resolvidos;
import java.util.Scanner;

public class B1018 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            int nota100 = 100;
            int nota50 = 50;
            int nota20 = 20;
            int nota10 = 10;
            int nota5 = 5;
            int nota2 = 2;
            int nota1 = 1;

            int valorParaDecompor = scanner.nextInt();
            System.out.println(valorParaDecompor);

            int quantidadeDeNotas100 = valorParaDecompor / nota100;
            valorParaDecompor = valorParaDecompor % nota100;

            int quantidadeDeNotas50 = valorParaDecompor / nota50;
            valorParaDecompor = valorParaDecompor % nota50;

            int quantidadeDeNotas20 = valorParaDecompor / nota20;
            valorParaDecompor = valorParaDecompor % nota20;

            int quantidadeDeNotas10 = valorParaDecompor / nota10;
            valorParaDecompor = valorParaDecompor % nota10;

            int quantidadeDeNotas5 = valorParaDecompor / nota5;
            valorParaDecompor = valorParaDecompor % nota5;

            int quantidadeDeNotas2 = valorParaDecompor / nota2;
            valorParaDecompor = valorParaDecompor % nota2;

            int quantidadeDeNotas1 = valorParaDecompor / nota1;
            valorParaDecompor = valorParaDecompor % nota1;

            System.out.println(quantidadeDeNotas100 + " nota(s) de R$ 100,00");
            System.out.println(quantidadeDeNotas50 + " nota(s) de R$ 50,00");
            System.out.println(quantidadeDeNotas20 + " nota(s) de R$ 20,00");
            System.out.println(quantidadeDeNotas10 + " nota(s) de R$ 10,00");
            System.out.println(quantidadeDeNotas5 + " nota(s) de R$ 5,00");
            System.out.println(quantidadeDeNotas2 + " nota(s) de R$ 2,00");
            System.out.println(quantidadeDeNotas1 + " nota(s) de R$ 1,00");

        }
    }
}