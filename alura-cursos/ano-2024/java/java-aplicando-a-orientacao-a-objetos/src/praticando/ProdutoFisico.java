package praticando;

public class ProdutoFisico implements ICalculavel {

    double preco;

    @Override
    public double calcularPrecoFinal() {
        return preco + (preco * 0.1);
    }

}
