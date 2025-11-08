import java.util.List;

public class colecao_Map {
    public static void main(String[] args) {
        List<Double> valoresVendas = List.of(100.00, 200.00, 500.00, 1000.00);

        List<Double> comissoes = valoresVendas.stream()
            .map(valor -> valor * 0.05)
            .toList();
        System.out.println("Valores das comissões: " + comissoes);

        var totalVendas = valoresVendas.stream()
            .reduce(0.0, Double::sum);

        System.out.println("Valor total das vendas: " + totalVendas);


    }
}
