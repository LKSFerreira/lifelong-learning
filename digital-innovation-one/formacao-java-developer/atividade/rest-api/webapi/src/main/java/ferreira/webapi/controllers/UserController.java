package ferreira.webapi.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ferreira.webapi.models.UserModel;
import ferreira.webapi.repositories.IUserRepository;

@RestController
@RequestMapping("/api/v1/users/")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @GetMapping
    public List<UserModel> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("{id}")
    public UserModel getById(@PathVariable UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping("email/{email}")
    public UserModel getByEmail(@PathVariable String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @PostMapping
    public UserModel createUser(@RequestBody UserModel user) {
        return userRepository.save(user);
    }
}
