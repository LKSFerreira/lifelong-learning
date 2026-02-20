package app.cryptostatus;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import app.cryptostatus.principal.CryptoStatusApp;

@SpringBootApplication
public class CryptostatusApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CryptostatusApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CryptoStatusApp app = new CryptoStatusApp();
		app.run();
	}

}
