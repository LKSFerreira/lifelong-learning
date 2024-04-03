package ferreira.crudrestapidatajpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ferreira.crudrestapidatajpa.models.AlunoModel;
import ferreira.crudrestapidatajpa.models.form.AlunoForm;
import ferreira.crudrestapidatajpa.services.impl.AlunoServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

  @Autowired
  private AlunoServiceImpl alunoServiceImpl;

  @GetMapping
  public List<AlunoModel> getAll(@RequestParam(value = "dataNascimento") String dataNascimento) {
    return alunoServiceImpl.getAll(dataNascimento);
  }

  @PostMapping
  public AlunoModel create(@Valid @RequestBody AlunoForm form) {
    return alunoServiceImpl.create(form);
  }

}
