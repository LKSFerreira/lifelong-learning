class Aluno {
    String nome;
    double nota1;
    double nota2;

    private double calcularMedia() {
        return (nota1 + nota2) / 2;
    }

    private boolean estaAprovado() {
        double media = calcularMedia();
        return media >= 7.0;
    }

    public void getAluno() {
        System.out.println("Nome: " + nome);
        System.out.println("Nota 1: " + nota1);
        System.out.println("Nota 2: " + nota2);
        System.out.println("Média: " + calcularMedia());
        System.out.println("Status: " + (estaAprovado() ? "Aprovado" : "Reprovado") + "\n");
    }

}

public class _05_calculando_notas {
    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        aluno.nome = "João";
        aluno.nota1 = 8.5;
        aluno.nota2 = 6.0;
        aluno.getAluno();

        Aluno aluno2 = new Aluno();
        aluno2.nome = "Maria";
        aluno2.nota1 = 5.0;
        aluno2.nota2 = 4.5;
        aluno2.getAluno();

    }
}