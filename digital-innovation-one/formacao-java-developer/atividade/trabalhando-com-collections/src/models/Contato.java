package models;

public class Contato implements Comparable<Contato> {

    private String nome;
    private String telefone;

    public Contato() {
    }

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    @Override
    public String toString() {
        return "[ nome = " + nome + ", telefone = " + telefone + " ]";
    }

    @Override
    public int compareTo(Contato o) {
        int nome = this.getNome().compareTo(o.getNome());
        if (nome != 0) {
            return nome;
        }
        return this.getTelefone().compareTo(o.getTelefone());
    }
}
