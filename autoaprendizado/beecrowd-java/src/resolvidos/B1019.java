package resolvidos;
import java.util.Scanner;

public class B1019 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            int tempoEmSegundos = scanner.nextInt();
            int horas = tempoEmSegundos / 3600;
            tempoEmSegundos = tempoEmSegundos % 3600;

            int minutos = tempoEmSegundos / 60;
            tempoEmSegundos = tempoEmSegundos % 60;
            
            System.out.println(horas + ":" + minutos + ":" + tempoEmSegundos);
        }
    }
}