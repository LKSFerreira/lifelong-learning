package praticando;

public class ConversorMoedas implements IConversaoFinanceira {

    double valorEmReais;

    @Override
    public double converterDollarParaReal(double cotacaoDollar) {
        return valorEmReais * cotacaoDollar;
    }

}
