package praticando;

public class Produto implements IVendavel {
    private double preco;

    public Produto(double preco) {
        this.preco = preco;
    }

    @Override
    public double valorTotal(int quantidade, double desconto) {
        return (preco * quantidade) - (preco * quantidade * (desconto / 100));
    }

}
