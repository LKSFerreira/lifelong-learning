import context.Robo;
import controllers.ComportamentoAgressivo;
import controllers.ComportamentoDefensivo;
import controllers.ComportamentoNormal;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println();

        Robo robo = new Robo();
        System.out.println("Atribuir comportamento normal ao robo");
        robo.setStrategyComportamento(new ComportamentoNormal());
        robo.mover();

        System.out.println("Atribuir comportamento agressivo ao robo");
        robo.setStrategyComportamento(new ComportamentoAgressivo());
        robo.mover();

        System.out.println("Atribuir comportamento defensivo ao robo");
        robo.setStrategyComportamento(new ComportamentoDefensivo());
        robo.mover();
    }
}
