package resolvidos;
import java.util.Scanner;

public class B1044 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            String[] entradaValores = scanner.nextLine().split(" ");
            double[] valores = new double[entradaValores.length];

            for (int i = 0; i < entradaValores.length; i++) {
                valores[i] = Double.parseDouble(entradaValores[i]);
            }

            if (valores[0] % valores[1] == 0 || valores[1] % valores[0] == 0) {
                System.out.println("Sao Multiplos");
            } else {
                System.out.println("Nao sao Multiplos");
            }

        }
    }
}