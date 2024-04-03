package models.conta;

import interfaces.IConta;
import models.banco.Banco;
import models.cliente.Titular;

public abstract class Conta implements IConta {

    private static final int AGENCIAl = 2704;
    private static int sequencialConta = 10000;
    protected int numero;
    protected int agencia;
    protected double saldo;
    protected Titular titular;

    public Conta() {
        this.numero = sequencialConta++;
        this.agencia = AGENCIAl;
        Banco.addConta(this);
    }

    public Conta(double saldo) {
        this.numero = sequencialConta++;
        this.agencia = AGENCIAl;
        this.saldo = saldo;
        Banco.addConta(this);
    }

    public int getNumero() {
        return numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }



}
