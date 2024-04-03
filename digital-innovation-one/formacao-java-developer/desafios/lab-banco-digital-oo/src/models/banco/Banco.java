package models.banco;

import java.util.HashSet;
import java.util.List;

import models.conta.Conta;

public class Banco {

    private static final String NOME = "Banco Digital Java";
    private static HashSet<Conta> contas = new HashSet<>();

    private Banco() {
    }

    public static String getNome() {
        return NOME;
    }

    public HashSet<Conta> getContas() {
        return contas;
    }

    public static void addConta(Conta conta) {
        contas.add(conta);
    }

    public static int getQuantidadeContas() {
        return contas.size();
    }    

}
