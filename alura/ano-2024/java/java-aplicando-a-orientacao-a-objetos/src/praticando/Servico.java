package praticando;

public class Servico implements IVendavel {

    @Override
    public double valorTotal(int quantidade, double desconto) {
        return 100 * quantidade - (100 * quantidade * (desconto / 100));
    }

}
