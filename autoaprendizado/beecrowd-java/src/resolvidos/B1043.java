package resolvidos;
import java.util.Scanner;

public class B1043 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            String[] entradaValores = scanner.nextLine().split(" ");
            double[] valores = new double[entradaValores.length];

            for (int i = 0; i < entradaValores.length; i++) {
                valores[i] = Double.parseDouble(entradaValores[i]);
            }

            // Se formar um tringulo, caulcular o perimetro,
            // se não calcular a area do trapezio
            
            if (valores[0] + valores[1] > valores[2] && valores[0] + valores[2] > valores[1]
                    && valores[1] + valores[2] > valores[0]) {
                double perimetro = valores[0] + valores[1] + valores[2];
                System.out.printf("Perimetro = %.1f\n", perimetro);
            } else {
                double area = ((valores[0] + valores[1]) * valores[2]) / 2;
                System.out.println("Area = " + area);
            }

        }
    }
}