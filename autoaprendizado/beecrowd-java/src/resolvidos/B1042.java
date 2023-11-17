package resolvidos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B1042 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            String[] entradaValores = scanner.nextLine().split(" ");
            List<Integer> valores = new ArrayList<Integer>();

            for (int i = 0; i < entradaValores.length; i++) {
                valores.add(Integer.parseInt(entradaValores[i]));
            }

            valores.sort((a, b) -> a.compareTo(b));

            valores.forEach(System.out::println);

            System.out.println();

            for (String valor : entradaValores) {
                System.out.println(valor);
            }
        }
    }
}