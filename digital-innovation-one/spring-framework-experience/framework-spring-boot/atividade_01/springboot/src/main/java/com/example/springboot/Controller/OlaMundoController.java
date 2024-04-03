package com.example.springboot.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class OlaMundoController {

    @GetMapping("/")
    public String olaMundo() {
        // Retona um Olá mundo dentro de uma tag h1
        return "<h1>Olá Mundo!</h1>";
    }

}
