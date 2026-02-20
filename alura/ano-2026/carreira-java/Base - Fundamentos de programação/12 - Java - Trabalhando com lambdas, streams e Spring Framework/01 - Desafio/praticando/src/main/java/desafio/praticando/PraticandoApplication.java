package desafio.praticando;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		AppAvaliacao appAvaliacao = new AppAvaliacao();
		appAvaliacao.executar();
	}
}
