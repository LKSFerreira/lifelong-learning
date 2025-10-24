import java.util.Locale;

// Define a classe Devolucao
class Devolucao {
    String titulo;
    int diasAtraso;
    final double VALOR_MULTA_POR_DIA = 2.50;

    /**
     * Calcula o valor total da multa com base nos dias de atraso.
     * @return O valor total da multa.
     */
    private double calcularMulta() {
        return this.diasAtraso * VALOR_MULTA_POR_DIA;
    }

    /**
     * Mostra o título do livro e o valor da multa formatado.
     */
    public void exibirDetalhes() {
        double valorTotalMulta = calcularMulta();

        // Formata a string de saída usando printf para garantir o formato correto
        System.out.printf(Locale.of("pt", "BR"), "Livro: %s | Multa por %d dias de atraso: R$ %.2f%n",
                this.titulo,
                this.diasAtraso,
                valorTotalMulta);
    }
}

public class _09_multa_atraso {

    public static void main(String[] args) {
        // Cria uma instância da devolução
        Devolucao pedido = new Devolucao();
        pedido.titulo = "Dom Casmurro";
        pedido.diasAtraso = 3;

        // Exibe os detalhes da multa
        pedido.exibirDetalhes();
    }

}
