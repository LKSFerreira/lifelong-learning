package app.cryptostatus;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CryptostatusApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CryptostatusApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Ola mundo");
	}

}
