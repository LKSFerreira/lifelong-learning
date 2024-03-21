package br.com.lksferreira.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired // Gerencia todo o ciclo de vida do objeto userRepository
    private IUserRepository userRepository;

    @GetMapping("/test")
    public String test() {
        for (int i = 0; i < 5; i++) {
            System.out.println("-");
        }
        
        return "sucess";
    }

    @SuppressWarnings("null")
    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody UserModel user) {

        var passwordCrypt = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
        user.setPassword(passwordCrypt);

        var userExists = userRepository.findByUsername(user.getUsername());
        if (userExists != null) {
            return ResponseEntity.badRequest().body("Usuário já existe");
        }

        var userCreated = userRepository.save(user);
        return ResponseEntity.created(null).body(userCreated);
    }

}
