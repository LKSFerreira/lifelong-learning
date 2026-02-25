package desafio.praticando;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import desafio.praticando.models.DesafioStream;

@SpringBootApplication
public class PraticandoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PraticandoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// AppContador appContador = new AppContador();
		// appContador.executar();

		// AppTarefa appTarefa = new AppTarefa();
		// appTarefa.executar();

		// AppAvaliacao appAvaliacao = new AppAvaliacao();
		// appAvaliacao.executar();

		// Calculadora calculadora = new Calculadora();
		// var resultadoMultiplicacao = calculadora.multiplicacao(3, 9);
		// System.out.println("\nResultado da multiplicação: " + resultadoMultiplicacao
		// + "\n");

		// ICalculadora calculdoraLambda = (x, y) -> x * y;
		// var resultadoMultiplicacaoLambda = calculdoraLambda.multiplicacao(3, 9);
		// System.out.println("\nResultado da multiplicação com lambda: " +
		// resultadoMultiplicacaoLambda + "\n");

		// calculadora.isPrimo(2);
		// calculadora.isPrimo(5);
		// calculadora.isPrimo(4);
		// System.out.println();

		System.out.println();
		DesafioStream.executar();
		// Lista.executar();
		System.out.println();

	}
}
