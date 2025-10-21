import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class _10_carrinho_de_compras {

    public static void main(String[] args) {
        // Cria a lista de itens (carrinho de compras)
        List<Item> carrinho = new ArrayList<>();

        // Cria o primeiro item e o adiciona ao carrinho
        Item item1 = new Item("Notebook", 2500.0, 1);
        carrinho.add(item1);

        // Cria o segundo item e o adiciona ao carrinho
        Item item2 = new Item("Headset", 150.0, 1);
        carrinho.add(item2);

        // Calcula o valor total da compra
        double totalCompra = 0.0;
        for (Item item : carrinho) {
            totalCompra += item.getValorTotalItem();
        }

        // Formata o valor total como moeda brasileira e exibe no console
        NumberFormat formatador = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
        System.out.println("Total da compra: " + formatador.format(totalCompra));

        // Exibe os itens do carrinho
        System.out.println("Itens no carrinho:");
        carrinho.forEach(System.out::println);
    }

    // Define a classe estática Item
    public static class Item {
        String nome;
        double preco;
        int quantidade;

        public Item(String nome, double preco, int quantidade) {
            this.nome = nome;
            this.preco = preco;
            this.quantidade = quantidade;
        }
        
        /**
         * Retorna o valor total do item (preço * quantidade).
         * @return O valor total do item.
         */
        public double getValorTotalItem() {
            return this.preco * this.quantidade;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "nome='" + nome + '\'' +
                    ", preco=" + preco +
                    ", quantidade=" + quantidade +
                    '}';
        }
    }
}