import models.banco.Banco;
import models.conta.Conta;
import models.conta.ContaCorrente;
import models.conta.ContaPoupanca;

public class App {
    public static void main(String[] args) throws Exception {
        Conta contaCorrente = new ContaCorrente();
        contaCorrente.imprimirExtrato();
        contaCorrente.depositar(200);
        contaCorrente.sacar(50);
        System.out.println(contaCorrente.getSaldo());
        
        System.out.println();

        Conta contaPoupanca = new ContaPoupanca(100);
        contaPoupanca.imprimirExtrato();
        contaPoupanca.sacar(50);
        contaPoupanca.depositar(150);
        
        contaCorrente.transferir(100, contaPoupanca);
        System.out.println(contaPoupanca.getSaldo());
        System.out.println();

        System.out.println("Nome do banco: " + Banco.getNome());
        System.out.println("Quantidade de contas: " + Banco.getQuantidadeContas());
    }
}
