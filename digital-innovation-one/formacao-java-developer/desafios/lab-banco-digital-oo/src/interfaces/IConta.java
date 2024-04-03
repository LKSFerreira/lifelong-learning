package interfaces;

import models.conta.Conta;

public interface IConta {

    void depositar(double valor);

    void sacar(double valor);

    void transferir(double valor, Conta conta);

    public void imprimirExtrato();

}
