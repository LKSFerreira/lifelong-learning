package desafio.praticando.models;

import desafio.praticando.interfaces.ICalculadora;

public class Calculadora implements ICalculadora {

    @Override
    public int multiplicacao(int x, int y) {
        return x * y;
    }

    @Override
    public void isPrimo(int x) {
        if (x < 0) {
            System.out.println("Não é primo");
            return;
        }

        switch (x) {
            case 1:
                System.out.println("Não é primo");
                break;

            case 2:
                System.out.println("É primo");
                break;

            default:
                if (x % 2 == 0) {
                    System.out.println("Não é primo");
                    return;
                }

                for (int i = 3; i < x; i+=2) {
                    if (x % i == 0) {
                        System.out.println("Não é primo");
                        return;
                    }
                }
                System.out.println("É primo");
                break;
        }
    }

}
