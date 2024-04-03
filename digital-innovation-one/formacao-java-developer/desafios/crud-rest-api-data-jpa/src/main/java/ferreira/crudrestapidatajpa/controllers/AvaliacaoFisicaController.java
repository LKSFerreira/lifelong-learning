package ferreira.crudrestapidatajpa.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ferreira.crudrestapidatajpa.models.AvaliacaoFisicaModel;
import ferreira.crudrestapidatajpa.models.form.AvaliacaoFisicaForm;
import ferreira.crudrestapidatajpa.services.impl.AvaliacaoFisicaServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

  @Autowired
  private AvaliacaoFisicaServiceImpl avaliacaoFisicaServiceImpl;

  @PostMapping
  public AvaliacaoFisicaModel create(@RequestBody AvaliacaoFisicaForm avaliacaoFisicaModel) {
    return avaliacaoFisicaServiceImpl.create(avaliacaoFisicaModel);
  }

  @GetMapping
  public List<AvaliacaoFisicaModel> getAll() {
    return avaliacaoFisicaServiceImpl.getAll();
  }

  @GetMapping("/{id}")
  public AvaliacaoFisicaModel get(@PathVariable UUID id) {
    return avaliacaoFisicaServiceImpl.getById(id);
  }

  @GetMapping("/aluno/{alunoId}")
  public List<AvaliacaoFisicaModel> getAllByAlunoId(@Valid @PathVariable UUID alunoId) {
    return avaliacaoFisicaServiceImpl.getAllByAlunoId(alunoId);
  }

}
