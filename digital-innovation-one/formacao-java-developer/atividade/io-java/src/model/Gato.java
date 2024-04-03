package model;

import java.io.Serializable;

public class Gato implements Serializable{
    String nome;
    int idade;
    String cor;

    public Gato() {
    }

    public Gato(String nome, int idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Gato [nome=" + nome + ", idade=" + idade + ", cor=" + cor + "]";
    }

    
    
}


