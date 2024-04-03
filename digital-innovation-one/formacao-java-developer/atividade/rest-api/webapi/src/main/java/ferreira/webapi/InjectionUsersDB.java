package ferreira.webapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import ferreira.webapi.models.UserModel;
import ferreira.webapi.repositories.IUserRepository;

@Configuration
public class InjectionUsersDB implements CommandLineRunner {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        UserModel admin = new UserModel("Administrador Atos", "admin", "admin", "admin@atos.net");
        admin.setId(UUID.fromString("a111a111-a1a1-a1a1-a1a1-a111a111a111"));

        List<UserModel> users = new ArrayList<>(Arrays.asList(
                admin,
                new UserModel("Usuario Atos", "user", "user", "user@atos.net"),
                new UserModel("Fulano de Tal", "fulano", "fulano", "fulano@atos.net"),
                new UserModel("Ciclano de Tal", "ciclano", "ciclano", "ciclano@anots.net"),
                new UserModel("Beltrano de Tal", "beltrano", "beltrano", "beltrano@atos.net")));

        userRepository.saveAll(users);

    }

}
