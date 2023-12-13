package ferreira.restapiswagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RestApiSwaggerApplication {

  public static void main(String[] args) {
    SpringApplication.run(RestApiSwaggerApplication.class, args);
  }

}
