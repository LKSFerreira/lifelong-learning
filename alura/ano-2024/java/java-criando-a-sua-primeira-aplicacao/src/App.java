public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\nHello, World!");

        // Calcula duas a média deciamal entre dois valores
        double valor1 = 10;
        double valor2 = 20;
        double media = (valor1 + valor2) / 2;
        System.out.println("A média entre " + valor1 + " e " + valor2 + " é: " + media);

        // Fazendo um conversão explicita de um valor double para um valor int (Casting)
        double valorDouble = 10.55;
        int valorInt = (int) valorDouble;
        System.out.println("O valor double " + valorDouble + " convertido para int é: " + valorInt);

        // Concatenando Strings
        String nome = "Lucas";
        String sobrenome = "Ferreira";
        String nomeCompleto = nome + " " + sobrenome;
        System.out.println("Nome completo: " + nomeCompleto);

        // Realizando operações
        double precoProduto = 13.99;
        double quantidade = 10;
        double total = precoProduto * quantidade;
        System.out.println("O total da compra é: " + total);

        // Convertendo dolar para real
        double dolar = 4.94;
        double real = 50.00;
        double valorEmReal = dolar * real;
        System.out.println("O valor de " + real + " dolares em reais é: " + valorEmReal);

        // Desconto em produto
        double precoProdutoDesconto = 100.00;
        double desconto = 10;
        double valorDesconto = precoProdutoDesconto * (desconto / 100);
        double precoFinal = precoProdutoDesconto - valorDesconto;
        System.out.println("O valor do desconto é: " + valorDesconto);
        System.out.println("O valor final do produto com desconto é: " + precoFinal);

    }
}
