class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            System.out.println("Preço inválido.");
            this.preco = 0.0;
            return;
        }
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", preco=" + preco + "]";
    }

}

public class _03_cadastro_produto_validacao {
    public static void main(String[] args) {

        Produto produto1 = new Produto("Notebook", 2500.0);
        Produto produto2 = new Produto("Smartphone", 2000.0);

        produto1.setPreco(2300.0); // Atualiza preço válido
        produto2.setPreco(-500.0); // Tenta atualizar para preço inválido

        System.out.println(produto1);
        System.out.println(produto2);

    }

}
