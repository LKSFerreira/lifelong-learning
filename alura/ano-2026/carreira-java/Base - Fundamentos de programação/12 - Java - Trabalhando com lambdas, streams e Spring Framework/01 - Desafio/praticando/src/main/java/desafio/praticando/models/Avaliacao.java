package desafio.praticando.models;

import java.util.List;

public class Avaliacao<T> {
    private T item;
    private double nota;
    private String comentario;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Avaliacao [item=" + item + ", nota=" + nota + ", comentario=" + comentario + "]";
    }

    public static <T> double calculaMediaAvaliacoes(List<Avaliacao<?>> avaliacoes) {
        return avaliacoes.stream()
                .mapToDouble(Avaliacao::getNota)
                .average()
                .orElse(0.0);
    }

}
