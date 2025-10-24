class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void exibirInfo() {
        System.out.print("Nome: " + nome + ", Idade: " + idade);
    }

}

class Aluno extends Pessoa {
    private double nota;

    public Aluno(String nome, int idade, double nota) {
        super(nome, idade);
        this.nota = nota;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println(", Nota: " + nota);
    }

}

class Docente extends Pessoa {
    private String disciplina;

    public Docente(String nome, int idade, String disciplina) {
        super(nome, idade);
        this.disciplina = disciplina;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println(", Disciplina: " + disciplina);
    }

}

public class _05_sistema_escolar {
    public static void main(String[] args) {

        Aluno aluno = new Aluno("Vanny", 26, 9.5);
        aluno.exibirInfo();

        Docente docente = new Docente("Lucas", 35, "Física");
        docente.exibirInfo();

    }

}