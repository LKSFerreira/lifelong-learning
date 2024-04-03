import associacao.interfaces.Calculadora;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Calculadora calc = new Calculadora();
        calc.soma(10, 5);
        calc.subtracao(10, 5);
        calc.multiplicacao(10, 5);
        calc.divisao(10, 5);
    }
}
