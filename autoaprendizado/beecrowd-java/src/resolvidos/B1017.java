package resolvidos;
import java.util.Scanner;

public class B1017 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            
            int autonomiaCarro = 12;

            int tempoGasto = scanner.nextInt();
            int velocidadeMedia = scanner.nextInt();

            double distancia = tempoGasto * velocidadeMedia;
            double litrosNecessarios = distancia / autonomiaCarro;

            System.out.println(String.format("%.3f", litrosNecessarios));
        }
    }
}