package resolvidos;
import java.util.Scanner;

public class B1020 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            int tempoEmDias = scanner.nextInt();
            int anos = tempoEmDias / 365;
            tempoEmDias = tempoEmDias % 365;

            int meses = tempoEmDias / 30;
            tempoEmDias = tempoEmDias % 30;
            
            System.out.println(anos + " ano(s)");
            System.out.println(meses + " mes(es)");
            System.out.println(tempoEmDias + " dia(s)");
        }
    }
}