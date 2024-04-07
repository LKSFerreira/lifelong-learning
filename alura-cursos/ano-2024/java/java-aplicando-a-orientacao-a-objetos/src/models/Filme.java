package models;

import interfaces.IClassificalvel;

public class Filme extends Titulo {

    private String direto;

    public String getDireto() {
        return direto;
    }

    public void setDireto(String direto) {
        this.direto = direto;
    }

    @Override
    public int getClassificacao() {
        System.out.println("Filme " + this.getNome() + " é classificado como 4 estrelas.");
        return (int) this.pegaMedia() / 2;
    }

}
