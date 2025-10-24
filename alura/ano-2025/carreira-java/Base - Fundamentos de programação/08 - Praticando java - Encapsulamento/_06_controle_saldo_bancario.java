class Conta {
    private String titular;
    private double saldo;

    public Conta(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
        }
    }

    public void exibirSaldo() {
        System.out.println("Saldo atual: " + saldo);
    }
}

public class _06_controle_saldo_bancario {
    public static void main(String[] args) {
        Conta minhaConta = new Conta("Seu Nome", 1000.0);
        minhaConta.exibirSaldo();

        minhaConta.depositar(500.0);
        minhaConta.exibirSaldo();

        minhaConta.sacar(2000.0);
        minhaConta.exibirSaldo();
    }

}