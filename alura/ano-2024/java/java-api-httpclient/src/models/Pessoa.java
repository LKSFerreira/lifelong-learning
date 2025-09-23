package models;

import mapping.PessoaMapping;

public class Pessoa {

    private String nome;
    private int idade;
    private String cidade;
    private String estado;

    public Pessoa(PessoaMapping pessoaMapping) {
        this.nome = pessoaMapping.nome();
        this.idade = pessoaMapping.idade();
        this.cidade = pessoaMapping.cidade();
        this.estado = pessoaMapping.uf();
    }

    @Override
    public String toString() {
        return "Pessoa [nome: " + nome + ", idade: " + idade + ", cidade: " + cidade + ", estado: " + estado + "]";
    }
}
