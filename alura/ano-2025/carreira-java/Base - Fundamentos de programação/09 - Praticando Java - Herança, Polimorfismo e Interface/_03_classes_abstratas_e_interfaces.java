public class _03_classes_abstratas_e_interfaces {
    public static void main(String[] args) {

        System.out.println("\n=== Gerente ===\n");
        Gerente gerente = new Gerente("João", 5000);
        gerente.exibiInformacoes();
        gerente.setBonus(1000);

        gerente.reajustaSalario(10);
        System.out.println("Após reajuste:");
        gerente.calculaPLR();
        gerente.exibiInformacoes();

        gerente.aprovaProjeto("Projeto X");

        System.out.println("\n=== Desenvolvedor ===\n");

        Funcionario dev = new Desenvolvedor("Lucas", 4000, "Java");
        dev.exibiInformacoes();
        dev.reajustaSalario();
        System.out.println("Após reajuste:");
        dev.exibiInformacoes();
    }

    interface Aprovacoes {
        void aprovaProjeto(String nomeProjeto);
    }

    public static abstract class Funcionario {
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

        public abstract void calculaPLR();
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

        @Override
        public void calculaPLR() {
            System.out.println("PLR Desenvolvedor: " + salario / 12);
        }

    }

    public static class Gerente extends Funcionario implements Aprovacoes {

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

        @Override
        public void calculaPLR() {
            System.out.println("PLR Gerente: " + (salario + bonus) / 12);
        }

        @Override
        public void aprovaProjeto(String nomeProjeto) {
            System.out.println("Projeto " + nomeProjeto + " aprovado pelo gerente " + nome);
        }

    }

}