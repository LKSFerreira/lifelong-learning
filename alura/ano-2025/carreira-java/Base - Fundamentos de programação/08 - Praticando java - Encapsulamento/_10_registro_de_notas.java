import java.util.ArrayList;
import java.util.List;

class Disciplina {
    private String nome;
    private List<Double> notas = new ArrayList<>();
    private int notasInvalidas = 0;

    public Disciplina(String nome) {
        this.nome = nome;
    }

    public void adicionarNota(double nota) {
        if (nota >= 0 && nota <= 10) {
            notas.add(nota);
        } else {
            System.out.println("Nota inválida ignorada: " + nota);
            notasInvalidas++;
        }
    }

    public void exibirRelatorio() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        double media = soma / notas.size();

        System.out.println("Total de notas válidas: " + notas.size());
        System.out.println("Total de notas inválidas: " + notasInvalidas);
        System.out.printf("Média em %s: %.2f\n", nome, media);
    }
}

public class _10_registro_de_notas {

    public static void main(String[] args) {
        Disciplina matematica = new Disciplina("Matemática");
        matematica.adicionarNota(7.5);
        matematica.adicionarNota(11.0);
        matematica.adicionarNota(8.0);
        matematica.adicionarNota(-3.0);
        matematica.adicionarNota(9.5);
        matematica.exibirRelatorio();
    }

}
