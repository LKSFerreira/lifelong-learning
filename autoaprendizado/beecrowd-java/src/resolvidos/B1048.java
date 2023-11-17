package resolvidos;
import java.util.Scanner;

public class B1048 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            double salarioFuncionario = scanner.nextDouble();

            double novoSalario, reajusteGanho, percentualReajuste;

            if (salarioFuncionario <= 400) {
                percentualReajuste = 15;
                novoSalario = salarioFuncionario * (1 + (percentualReajuste / 100));
                reajusteGanho = salarioFuncionario * (percentualReajuste / 100);
            } else if (salarioFuncionario <= 800) {
                percentualReajuste = 12;
                novoSalario = salarioFuncionario * (1 + (percentualReajuste / 100));
                reajusteGanho = salarioFuncionario * (percentualReajuste / 100);
            } else if (salarioFuncionario <= 1200) {
                percentualReajuste = 10;
                novoSalario = salarioFuncionario * (1 + (percentualReajuste / 100));
                reajusteGanho = salarioFuncionario * (percentualReajuste / 100);
            } else if (salarioFuncionario <= 2000) {
                percentualReajuste = 7;
                novoSalario = salarioFuncionario * (1 + (percentualReajuste / 100));
                reajusteGanho = salarioFuncionario * (percentualReajuste / 100);
            } else {
                percentualReajuste = 4;
                novoSalario = salarioFuncionario * (1 + (percentualReajuste / 100));
                reajusteGanho = salarioFuncionario * (percentualReajuste / 100);
            }

            System.out.printf("Novo salario: %.2f\n", novoSalario);
            System.out.printf("Reajuste ganho: %.2f\n", reajusteGanho);
            System.out.printf("Em percentual: %.0f %%\n", percentualReajuste);
        }
    }
}