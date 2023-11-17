package resolvidos;
import java.util.Scanner;

public class B1047 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] entradaValores = scanner.nextLine().trim().split(" ");

            int horasInicio = Integer.parseInt(entradaValores[0]);
            int minutosInicio = Integer.parseInt(entradaValores[1]);
            int horasFim = Integer.parseInt(entradaValores[2]);
            int minutosFim = Integer.parseInt(entradaValores[3]);

            int duracaoDoJogoEmHoras = 0;
            int duracaoDoJogoEmMinutos = getMinutes(minutosInicio, minutosFim);

            if (horasInicio > horasFim) {
                duracaoDoJogoEmHoras = (24 - horasInicio) + horasFim;
                if (minutosInicio > minutosFim) {
                    duracaoDoJogoEmHoras--;
                }
                duracaoJogo(duracaoDoJogoEmHoras, duracaoDoJogoEmMinutos);

            } else if (horasInicio < horasFim) {
                duracaoDoJogoEmHoras = horasFim - horasInicio;
                if (horasInicio < horasFim && minutosInicio > minutosFim) {
                    duracaoDoJogoEmHoras--;
                }
                duracaoJogo(duracaoDoJogoEmHoras, duracaoDoJogoEmMinutos);

            } else {
                duracaoDoJogoEmHoras = 24;
                if (minutosInicio > minutosFim) {
                    duracaoDoJogoEmHoras--;
                } else if (minutosInicio < minutosFim) {
                    duracaoDoJogoEmHoras = 0;
                }
                duracaoJogo(duracaoDoJogoEmHoras, duracaoDoJogoEmMinutos);

            }

        }
    }

    private static int getMinutes(int minutosInicio, int minutosFim) {
        if (minutosInicio > minutosFim) {
            return (60 - minutosInicio) + minutosFim;
        }
        return minutosFim - minutosInicio;
    }

    private static void duracaoJogo(int duracaoDoJogoEmHoras, int duracaoDoJogoEmMinutos) {
        System.out.println(
                "O JOGO DUROU " + duracaoDoJogoEmHoras + " HORA(S) E " + duracaoDoJogoEmMinutos + " MINUTO(S)");
    }
}