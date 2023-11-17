package resolvidos;
import java.util.Scanner;

public class B1046 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] entradaValores = scanner.nextLine().trim().split(" ");

            int horaInicio = Integer.parseInt(entradaValores[0]);
            int horaFim = Integer.parseInt(entradaValores[1]);
            
            int duracaoDoJogoEmHoras;

            if (horaInicio == horaFim) {
                duracaoDoJogoEmHoras = 24;
            } else if (horaInicio > horaFim) {
                duracaoDoJogoEmHoras = (24 - horaInicio) + horaFim;
            } else {
                duracaoDoJogoEmHoras = horaFim - horaInicio;
            }
            
            System.out.println("O JOGO DUROU " + (duracaoDoJogoEmHoras) + " HORA(S)");
        }
    }
}