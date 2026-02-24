package desafio.praticando.interfaces;

@FunctionalInterface
public interface ICalculadora {
    int multiplicacao(int x, int y);

    default void isPrimo(int x) {
        System.out.println();
    };
}
