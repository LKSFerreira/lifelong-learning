package context;

import interfaces.Comportamento;

public class Robo {
    private Comportamento strategyComportamento;

    public void setStrategyComportamento(Comportamento strategy) {
        this.strategyComportamento = strategy;
    }

    public void mover() {
        this.strategyComportamento.mover();
    }

}
