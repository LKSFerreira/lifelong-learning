package associacao.interfaces;

public class Calculadora implements OperacoesMatematicas {

    @Override
    public void soma(double a, double b) {
        System.out.println("A soma de " + a + " + " + b + " é " + (a + b));
    }

    @Override
    public void subtracao(double a, double b) {
        System.out.println("A subtração de " + a + " - " + b + " é " + (a - b));
    }

    @Override
    public void multiplicacao(double a, double b) {
        System.out.println("A multiplicação de " + a + " * " + b + " é " + (a * b));
    }

}
