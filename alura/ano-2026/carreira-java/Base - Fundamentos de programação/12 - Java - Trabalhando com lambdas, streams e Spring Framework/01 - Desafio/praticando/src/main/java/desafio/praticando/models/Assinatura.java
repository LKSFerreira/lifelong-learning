package desafio.praticando.models;

import java.util.Date;

public class Assinatura {
    private String nome;
    private double preco;
    private Date expiraEm;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public Date getExpiraEm() {
        return expiraEm;
    }
    public void setExpiraEm(Date expiraEm) {
        this.expiraEm = expiraEm;
    }

    @Override
    public String toString() {
        return "Assinatura [nome=" + nome + ", preco=" + preco + ", expiraEm=" + expiraEm + "]";
    }
}
