import java.util.List;
import java.util.Comparator;

public class _10_calculando_estatisticas_das_notas {
    public static void main(String[] args) {
        // Cria uma lista contendo as notas dos alunos
        List<Double> notas = List.of(7.5, 8.0, 6.5, 9.0, 10.0);

        // Utiliza reduce() para calcular a soma total das notas
        // reduce(valor_inicial, operacao)
        Double somaNotas = notas.stream()
                .reduce(0.0, Double::sum);

        // Calcula a média das notas
        Double media = somaNotas / notas.size();

        // Determina a menor nota da lista
        // min() retorna um Optional, por isso usamos .get()
        Double menorNota = notas.stream()
                .min(Comparator.naturalOrder())
                .get();

        // Determina a maior nota da lista
        // max() retorna um Optional, por isso usamos .get()
        Double maiorNota = notas.stream()
                .max(Comparator.naturalOrder())
                .get();

        // Exibe os resultados no console com formatação
        System.out.println("A média das notas é: " + String.format("%.1f", media));
        System.out.println("A menor nota foi: " + menorNota);
        System.out.println("A maior nota foi: " + maiorNota);
    }
}
