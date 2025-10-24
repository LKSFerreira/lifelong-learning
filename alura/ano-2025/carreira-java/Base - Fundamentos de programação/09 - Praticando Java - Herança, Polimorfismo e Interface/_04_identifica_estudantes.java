public class _04_identifica_estudantes {
    public static void main(String[] args) {

        Aluno aluno1 = new Aluno("Maria", "Regular");
        aluno1.identificar();

        Bolsista aluno2 = new Bolsista("Lucas", "Bolsista");
        aluno2.identificar();

    }

    public static class Aluno {
        private String nome;
        protected String tipo;

        public Aluno(String nome, String tipo) {
            this.nome = nome;
            this.tipo = tipo;
        }

        public void identificar() {
            System.out.println("Aluno: " + nome + ", Tipo: " + tipo);
        }
    }

    public static class Bolsista extends Aluno {

        public Bolsista(String nome, String tipo) {
            super(nome, "Bolsista");
        }

    }
}
