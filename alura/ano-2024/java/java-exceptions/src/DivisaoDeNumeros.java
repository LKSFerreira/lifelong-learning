import java.util.Scanner;

public class DivisaoDeNumeros {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDigite um número: ");
        int numero = scanner.nextInt();
        System.out.println("Digite outro número: ");
        int numero2 = scanner.nextInt();

        try {
            System.out.println("A divisão de " + numero + " por " + numero2 + " é: " + (numero / numero2));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }

        System.out.println("Fim do programa");
    }
}
