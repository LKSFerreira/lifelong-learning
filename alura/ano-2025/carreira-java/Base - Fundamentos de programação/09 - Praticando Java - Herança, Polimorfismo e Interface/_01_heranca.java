class Funcionario {
    private final String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void reajustaSalario(double percentual) {
        this.salario += this.salario * percentual / 100;
    }

    @Override
    public String toString() {
        return "Funcionario{nome='" + nome + "', salario=" + salario + "}";
    }
}

class Desenvolvedor extends Funcionario {

    private String stack;

    public Desenvolvedor(String nome, double salario, String stack) {
        super(nome, salario);
        this.stack = stack;
    }
}

class Gerente extends Funcionario {

    private double bonus;

    public Gerente(String nome, double salario) {
        super(nome, salario);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

}

public class _01_heranca {
    public static void main(String[] args) {

        Gerente gerente = new Gerente("João", 5000);
        System.out.println(gerente.toString());

        gerente.reajustaSalario(10);
        System.out.println("Após reajuste:");
        System.out.println(gerente.toString());

        System.out.println("=== Desenvolvedor ===");
        Desenvolvedor dev = new Desenvolvedor("Lucas", 4000, "Java");
        System.out.println(dev.toString());
        dev.reajustaSalario(10);
        System.out.println("Após reajuste:");
        System.out.println(dev.toString());

    }

}