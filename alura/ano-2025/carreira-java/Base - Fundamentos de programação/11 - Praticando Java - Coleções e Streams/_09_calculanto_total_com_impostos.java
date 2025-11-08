import java.util.List;

public class _09_calculanto_total_com_impostos {
    public static void main(String[] args) {
        // Cria uma lista contendo os preços dos produtos
        List<Double> precosProdutos = List.of(29.99, 49.50, 15.75, 99.99);

        // Utiliza reduce() para calcular o total gasto
        // reduce(valor_inicial, operacao)
        // Começa com 0.0 e soma todos os preços
        Double totalSemImposto = precosProdutos.stream()
                .reduce(0.0, Double::sum);

        // Calcula o valor do imposto (8%) sobre o total
        Double imposto = totalSemImposto * 0.08;

        // Calcula o total com imposto
        Double totalComImposto = totalSemImposto + imposto;

        // Exibe o valor total antes e depois com duas casas decimais
        System.out.println("Valor total antes do imposto: " + String.format("%.2f", totalSemImposto));
        System.out.println("Valor total com imposto de 8%: " + String.format("%.2f", totalComImposto));
    }
}
