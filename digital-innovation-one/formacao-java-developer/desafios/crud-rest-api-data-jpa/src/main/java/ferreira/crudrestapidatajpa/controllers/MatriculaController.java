package ferreira.crudrestapidatajpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ferreira.crudrestapidatajpa.models.MatriculaModel;
import ferreira.crudrestapidatajpa.models.form.MatriculaForm;
import ferreira.crudrestapidatajpa.services.impl.MatriculaServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

  @Autowired
  private MatriculaServiceImpl matriculaServiceImpl;

  @PostMapping
  public MatriculaModel create(@Valid @RequestBody MatriculaForm form) {
    return matriculaServiceImpl.create(form);
  }

  @GetMapping
  public List<MatriculaModel> getAll(@RequestParam(value = "bairro") String bairro) {
    return matriculaServiceImpl.getAll(bairro);
  }

}
