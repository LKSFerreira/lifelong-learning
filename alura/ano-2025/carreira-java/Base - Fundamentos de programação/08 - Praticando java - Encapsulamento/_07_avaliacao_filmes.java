import java.util.ArrayList;
import java.util.List;

public class _07_avaliacao_filmes {
    public static void main(String[] args) {
        Filme matrix = new Filme("Matrix");
        matrix.adicionarAvaliacao(5);
        matrix.adicionarAvaliacao(4);
        matrix.adicionarAvaliacao(5);
        matrix.adicionarAvaliacao(3);
        matrix.adicionarAvaliacao(4);
        matrix.exibirMedia();
    }

    public static class Filme {
        private String titulo;
        private List<Integer> avaliacoes = new ArrayList<>();

        public Filme(String titulo) {
            this.titulo = titulo;
        }

        public void adicionarAvaliacao(int avaliacao) {
            if (avaliacao >= 1 && avaliacao <= 5) {
                avaliacoes.add(avaliacao);
            }
        }

        public void exibirMedia() {
            double soma = 0;
            for (int avaliacao : avaliacoes) {
                soma += avaliacao;
            }
            double media = soma / avaliacoes.size();
            System.out.printf("Média de avaliações para %s: %.2f\n", titulo, media);
        }
    }
}