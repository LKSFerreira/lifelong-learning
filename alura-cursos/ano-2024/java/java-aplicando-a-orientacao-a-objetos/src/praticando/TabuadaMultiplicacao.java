package praticando;

public class TabuadaMultiplicacao implements ITabuada {

    @Override
    public void mostrarTabuada(int numero) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
    }

}
