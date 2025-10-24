class Produto {
    String nome;
    double preco;
    int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public double calcularValorTotal() {
        return preco * quantidade;
    }

    public void exibirRelatorio() {
        System.out.println("Nome do Produto: " + nome);
        System.out.println("Preço Unitário: R$ " + String.format("%.2f", preco));
        System.out.println("Quantidade em Estoque: " + quantidade);
        System.out.println("Valor Total em Estoque: R$ " + String.format("%.2f", calcularValorTotal()));
    }
}

public class _01_relatorio_produto {
    public static void main(String[] args) {
        Produto produto = new Produto("Placa de Vídeo", 1500.00, 10);
        produto.exibirRelatorio();
    }
}
