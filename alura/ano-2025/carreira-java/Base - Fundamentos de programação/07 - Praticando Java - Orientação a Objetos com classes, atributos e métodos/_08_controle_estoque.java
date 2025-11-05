public class _08_controle_estoque {

    public static void main(String[] args) {
        // Cria uma instância do produto
        Produto item = new Produto();
        item.nome = "Camiseta";
        item.quantidade = 10;

        // Simula a primeira venda
        item.vender(3);

        // Simula a segunda venda, que deve falhar
        item.vender(8);
    }

    // Define a classe Produto
    public static class Produto {
        String nome;
        int quantidade;

        /**
         * Processa a venda de uma determinada quantidade do produto.
         * Subtrai do estoque se houver disponibilidade e exibe o status.
         * Caso contrário, exibe um alerta de estoque insuficiente.
         */
        public void vender(int quantidadeVendida) {
            if (quantidadeVendida <= this.quantidade) {
                // Se houver estoque suficiente, realiza a venda
                this.quantidade -= quantidadeVendida;
                System.out.printf("Venda realizada. Estoque restante de %s: %d%n", this.nome, this.quantidade);
            } else {
                // Se não houver estoque, exibe o alerta
                System.out.println("Estoque insuficiente");
            }
        }
    }
}
