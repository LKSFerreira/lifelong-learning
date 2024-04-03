package ferreira.designpatternwithspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesignPatternWithSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPatternWithSpringApplication.class, args);
	}

}
