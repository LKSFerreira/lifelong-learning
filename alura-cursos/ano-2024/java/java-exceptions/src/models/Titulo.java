package models;

import mapping.TituloRecord;

public class Titulo {

    private String nome;
    private String ano;
    private String duracaoEmMinutos;

    public Titulo(TituloRecord tituloRecord) {
        this.nome = tituloRecord.nome();
        this.ano = tituloRecord.ano();
        this.duracaoEmMinutos = tituloRecord.runtime();
    }

    @Override
    public String toString() {
        return "{ Nome: " + nome + ", Ano: " + ano + ", Duração em minutos: " + duracaoEmMinutos + " }";
    }

}
