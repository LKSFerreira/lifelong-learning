public class _02_polimorfismo {
    public static void main(String[] args) {

        Funcionario gerente = new Gerente("João", 5000);
        gerente.exibiInformacoes();
        ((Gerente) gerente).setBonus(1000);

        gerente.reajustaSalario(10);
        System.out.println("Após reajuste:");
        gerente.exibiInformacoes();

        System.out.println("=== Desenvolvedor ===");

        Funcionario dev = new Desenvolvedor("Lucas", 4000, "Java");
        dev.exibiInformacoes();
        dev.reajustaSalario();
        System.out.println("Após reajuste:");
        dev.exibiInformacoes();
    }

    public static class Funcionario {
        protected String nome;
        protected double salario;

        public Funcionario(String nome, double salario) {
            this.nome = nome;
            this.salario = salario;
        }

        public String getNome() {
            return nome;
        }

        public void reajustaSalario() {
            this.salario += 500;
            System.out.println("Salário reajustado em 500 reais.");
        }

        public void reajustaSalario(double percentual) {
            this.salario += this.salario * percentual / 100;
        }

        public void exibiInformacoes() {
            System.out.println("Funcionário: " + nome + ", Salário: " + salario);
        }
    }

    public static class Desenvolvedor extends Funcionario {

        private String stack;

        public Desenvolvedor(String nome, double salario, String stack) {
            super(nome, salario);
            this.stack = stack;
        }

        @Override
        public void exibiInformacoes() {
            System.out.println("Desenvolvedor: " + nome + ", Salário: " + salario + ", Stack: " + stack);
        }

    }

    public static class Gerente extends Funcionario {

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

        @Override
        public void exibiInformacoes() {
            System.out.println("Gerente: " + nome + ", Salário: " + salario + ", Bônus: " + bonus);
        }

    }
}