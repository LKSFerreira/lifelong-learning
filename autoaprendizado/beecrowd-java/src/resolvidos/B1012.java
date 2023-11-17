package resolvidos;
import java.util.Scanner;

public class B1012 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            String[] linha = scanner.nextLine().replace(",", ".").split(" ");
            double valorA = Double.parseDouble(linha[0]);
            double valorB = Double.parseDouble(linha[1]);
            double valorC = Double.parseDouble(linha[2]);

            double triangulo = valorA * valorC / 2;
            double circulo = 3.14159 * Math.pow(valorC, 2);
            double trapezio = (valorA + valorB) * valorC / 2;
            double quadrado = Math.pow(valorB, 2);
            double retangulo = valorA * valorB;

            System.out.printf("TRIANGULO: %.3f\n", triangulo);
            System.out.printf("CIRCULO: %.3f\n", circulo);
            System.out.printf("TRAPEZIO: %.3f\n", trapezio);
            System.out.printf("QUADRADO: %.3f\n", quadrado);
            System.out.printf("RETANGULO: %.3f\n", retangulo);
        }
    }
}