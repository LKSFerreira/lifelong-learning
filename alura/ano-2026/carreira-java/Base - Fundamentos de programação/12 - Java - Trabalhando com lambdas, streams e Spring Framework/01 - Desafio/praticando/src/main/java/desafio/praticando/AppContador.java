package desafio.praticando;

import java.util.Scanner;

public class AppContador {
    private int numero = 0;

    public void executar() {
        LayoutTerminal.msg("Digite um valor numérico entre 1 e 100");

        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                System.out.println();
            }
        }

        for (int i = 1; i <= numero; i++) {
            System.out.print(i + " ");
        }

        LayoutTerminal.finalDeCodigo();
    }
}
