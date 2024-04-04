import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {
    public static void main(String[] args) {
        System.out.println("\nJogo de Adivinhação!");

        int numeroSecreto = new Random().nextInt(101);
        int contador = 0;
        
        Scanner scanner = new Scanner(System.in);
        while (contador < 5) {
            System.out.println("Digite um número entre 0 e 100: ");
            int numero = scanner.nextInt();

            if (numero == numeroSecreto) {
                System.out.println("Parabéns, você acertou!");
                break;
            } else if (numero > numeroSecreto) {
                System.out.println("O número secreto é menor!\n");
            } else {
                System.out.println("O número secreto é maior!\n");
            }

            contador++;
        }

        if (contador == 5) {
            System.out.println("Você perdeu! O número secreto era: " + numeroSecreto);
        }

        scanner.close();
    }
}
