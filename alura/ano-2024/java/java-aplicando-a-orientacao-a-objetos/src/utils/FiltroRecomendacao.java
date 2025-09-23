package utils;

import interfaces.IClassificalvel;

public class FiltroRecomendacao {
    public void filtra(IClassificalvel classificavel) {
        if (classificavel.getClassificacao() >= 4) {
            System.out.println("Está entre os melhores do momento!");
        } else {
            System.out.println("Coloque na sua lista para assitir depois");
        }
    }   
}
