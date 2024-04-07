package utils;

import models.Filme;
import models.Serie;

public class CalculadoraDeTempo {
    private int tempoTotalEmMinutos;

    public int getTempoTotalEmMinutos() {
        return tempoTotalEmMinutos;
    }

    public void inclui(Filme filme) {
        tempoTotalEmMinutos += filme.getDuracaoEmMinutos();
    }

    public void inclui(Serie serie) {
        tempoTotalEmMinutos += serie.getDuracaoEmMinutos();
    }
}
