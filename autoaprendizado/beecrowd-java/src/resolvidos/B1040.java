package resolvidos;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class B1040 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            String[] entradaStrings = scanner.nextLine().split(" ");
            double nota1 = Double.parseDouble(entradaStrings[0]);
            double nota2 = Double.parseDouble(entradaStrings[1]);
            double nota3 = Double.parseDouble(entradaStrings[2]);
            double nota4 = Double.parseDouble(entradaStrings[3]);

            int pesoNota1 = 2;
            int pesoNota2 = 3;
            int pesoNota3 = 4;
            int pesoNota4 = 1;

            double mediaPonderada = (nota1 * pesoNota1 + nota2 * pesoNota2 + nota3 * pesoNota3 + nota4 * pesoNota4)
                    / (pesoNota1 + pesoNota2 + pesoNota3 + pesoNota4);

            BigDecimal mediaArredondada = new
            BigDecimal(Double.toString(mediaPonderada));
            mediaArredondada = mediaArredondada.setScale(1, RoundingMode.HALF_DOWN);

            System.out.printf("Media: %.1f\n", mediaArredondada);

            if (mediaPonderada < 5) {
                System.out.println("Aluno reprovado.");
            } else if (mediaPonderada >= 7) {
                System.out.println("Aluno aprovado.");
            } else {
                System.out.println("Aluno em exame.");

                double notaExame = scanner.nextDouble();
                System.out.printf("Nota do exame: %.1f\n", notaExame);

                double mediaFinal = (mediaPonderada + notaExame) / 2;

                if (mediaFinal >= 5) {
                    System.out.println("Aluno aprovado.");
                    System.out.println("Media final: " + mediaFinal);
                } else {
                    System.out.println("Aluno reprovado.");
                }
            }
        }
    }
}