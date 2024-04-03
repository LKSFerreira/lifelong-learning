package associacao.interfaces;

public interface OperacoesMatematicas {

    void soma(double a, double b);

    void subtracao(double a, double b);

    void multiplicacao(double a, double b);

    default void divisao(double a, double b) {
        if (b == 0) {
            System.out.println("Não é possível dividir por zero!");
        } else {
            System.out.println("A divisão de " + a + " / " + b + " é " + (a / b));
        }
    }
}
