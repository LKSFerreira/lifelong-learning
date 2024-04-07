package models;

import interfaces.IClassificalvel;

public class Episodio implements IClassificalvel {

    private int numero;
    private String nome;
    private Serie serie;
    private int totalVisualizacoes;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getTotalVisualizacoes() {
        return totalVisualizacoes;
    }

    public void setTotalVisualizacoes(int totalVisualizacoes) {
        this.totalVisualizacoes = totalVisualizacoes;
    }

    @Override
    public int getClassificacao() {
        if (totalVisualizacoes > 100) {
            System.out.println("Episódio " + numero + " da série " + serie.getNome() + " é classificado como 5 estrelas.");
            return 4;
        } else {
            return 3;
        }
    }

}
