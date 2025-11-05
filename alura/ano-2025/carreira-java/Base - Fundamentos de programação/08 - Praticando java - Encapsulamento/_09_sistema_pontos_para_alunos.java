public class _09_sistema_pontos_para_alunos {

    public static void main(String[] args) {
        Aluno aluno = new Aluno("Fernanda");
        aluno.ganharPontos(120);
        aluno.exibirStatus();
    }

    public static class Aluno {
        private String nome;
        private int pontos;
        private int nivel;

        public Aluno(String nome) {
            this.nome = nome;
            this.pontos = 0;
            this.nivel = 1;
        }

        public void ganharPontos(int pontosGanhos) {
            this.pontos += pontosGanhos;
            this.nivel = (this.pontos / 100) + 1;
        }

        public void exibirStatus() {
            System.out.println("Nome: " + nome);
            System.out.println("Pontos: " + pontos);
            System.out.println("Nível: " + nivel);
        }
    }
}