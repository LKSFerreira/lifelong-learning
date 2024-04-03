package models.conta;

public class ContaPoupanca extends Conta {

    public ContaPoupanca() {
        super();
    }

    public ContaPoupanca(double saldo) {
        super(saldo);
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
    }

    @Override
    public void transferir(double valor, Conta conta) {
        this.sacar(valor);
        conta.depositar(valor);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("==============================");
        System.out.println("Extrato da Conta Poupança");
        System.out.println("Agência: " + this.agencia);
        System.out.println("Número: " + this.numero);
        System.out.println("Saldo: R$ " + String.format("%.2f", this.saldo));
        System.out.println("==============================");
    }  
}
