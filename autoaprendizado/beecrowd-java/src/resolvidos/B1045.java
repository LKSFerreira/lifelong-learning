package resolvidos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B1045 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            String[] entradaValores = scanner.nextLine().split(" ");

            double valorA = Double.parseDouble(entradaValores[0]);
            double valorB = Double.parseDouble(entradaValores[1]);
            double valorC = Double.parseDouble(entradaValores[2]);

            List<Double> listaValores = new ArrayList<Double>();
            listaValores.add(valorA);
            listaValores.add(valorB);
            listaValores.add(valorC);

            // Ordena a lista em ordem decrescente
            listaValores.sort((a, b) -> b.compareTo(a));

            valorA = listaValores.get(0);
            valorB = listaValores.get(1);
            valorC = listaValores.get(2);

            if (valorA >= valorB + valorC) {
                System.out.println("NAO FORMA TRIANGULO");
            } else {

                if (Math.pow(valorA, 2) > (Math.pow(valorB, 2) + Math.pow(valorC, 2))) {
                    System.out.println("TRIANGULO OBTUSANGULO");

                }
            }

            if (Math.pow(valorA, 2) == (Math.pow(valorB, 2) + Math.pow(valorC, 2))) {
                System.out.println("TRIANGULO RETANGULO");
            }

            if (Math.pow(valorA, 2) < (Math.pow(valorB, 2) + Math.pow(valorC, 2))) {
                System.out.println("TRIANGULO ACUTANGULO");

            }

            if (valorA == valorB && valorB == valorC) {
                System.out.println("TRIANGULO EQUILATERO");
            }

            if (((valorA == valorB || valorA == valorC) && (valorB != valorC))
                    || ((valorB == valorA || valorB == valorC)) && (valorA != valorC)) {
                System.out.println("TRIANGULO ISOSCELES");
            }
        }
    }
}