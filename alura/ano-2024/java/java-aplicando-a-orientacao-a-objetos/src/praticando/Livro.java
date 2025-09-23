package praticando;

public class Livro implements ICalculavel {

    double preco;

    @Override
    public double calcularPrecoFinal() {
        return preco - (preco * 0.25);
    }

}
