import java.text.NumberFormat;
import java.util.Locale;

// Define a classe ContaDigital
class ContaDigital {
    double saldo;

    /**
     * Redefine o valor do saldo para 0.0.
     */
    public void zerarSaldo() {
        this.saldo = 0.0;
    }

    /**
     * Mostra o saldo atual formatado como moeda brasileira.
     */
    public void exibirSaldo() {
        // Cria um formatador de moeda para o padrão brasileiro
        NumberFormat formatador = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
        System.out.println("Saldo atual: " + formatador.format(this.saldo));
    }
}

public class _03_zerando_saldo {

    public static void main(String[] args) {
        // Cria uma instância da classe ContaDigital
        ContaDigital conta = new ContaDigital();

        // Define o saldo inicial
        conta.saldo = 1579.42;

        // Exibe o saldo inicial
        conta.exibirSaldo();

        // Zera o saldo da conta
        conta.zerarSaldo();

        // Exibe o saldo após a operação
        conta.exibirSaldo();
    }

}
