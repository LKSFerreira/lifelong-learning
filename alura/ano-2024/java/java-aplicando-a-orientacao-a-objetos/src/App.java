import models.Episodio;
import models.Filme;
import models.Serie;
import utils.CalculadoraDeTempo;
import utils.FiltroRecomendacao;

public class App {
    public static void main(String[] args) throws Exception {
        Filme filme = new Filme();

        filme.setNome("The Matrix");
        filme.setAnoDeLancamento(1999);
        filme.setDuracaoEmMinutos(150);
        filme.setIncluidoNoPlano(true);

        // Pula uma linha
        System.out.println();

        filme.exibeFichaTecnica();
        filme.avalia(9);
        filme.avalia(8);
        filme.avalia(9);

        System.out.printf("Média de avaliações do filme: %.2f\n", filme.pegaMedia());

        // Pula uma linha
        System.out.println();

        Serie serie = new Serie();
        serie.setNome("Mr. Robot - Sociedade Hacker");
        serie.setAnoDeLancamento(2015);
        serie.setDuracaoEmMinutos(49);
        serie.setIncluidoNoPlano(true);
        serie.setTemporadas(4);
        serie.setAtiva(false);
        serie.setEpisodiosPorTemporada(12);
        serie.setMinutosPorEpisodio(49);
        serie.avalia(10);
        serie.avalia(9);
        serie.avalia(10);
        
        
        serie.exibeFichaTecnica();

        System.out.println("Duração total da série: " + serie.getDuracaoEmMinutos() + " minutos");

        // Pula uma linha
        System.out.println();

        Filme outroFilme = new Filme();

        // Filme sobre hackers
        outroFilme.setNome("Hackers");
        outroFilme.setAnoDeLancamento(1995);
        outroFilme.setDuracaoEmMinutos(100);
        outroFilme.setIncluidoNoPlano(true);

        CalculadoraDeTempo calculadoraDeTempo = new CalculadoraDeTempo();
        calculadoraDeTempo.inclui(filme);
        calculadoraDeTempo.inclui(serie);
        calculadoraDeTempo.inclui(outroFilme);

        System.out.println("Somatório de minutos de todos os títulos: " + calculadoraDeTempo.getTempoTotalEmMinutos());

        // Pula uma linha
        System.out.println();

        Episodio episodio = new Episodio();
        episodio.setNome("Hello, Friend");
        episodio.setNumero(1);
        episodio.setTotalVisualizacoes(200);
        episodio.setSerie(serie);

        FiltroRecomendacao filtroRecomendacao = new FiltroRecomendacao();
        filtroRecomendacao.filtra(filme);
        System.out.println();
        filtroRecomendacao.filtra(episodio);
        System.out.println();
        filtroRecomendacao.filtra(serie);

    }
}