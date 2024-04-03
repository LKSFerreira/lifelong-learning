package ferreira.crudrestapidatajpa.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ferreira.crudrestapidatajpa.models.AlunoModel;
import ferreira.crudrestapidatajpa.models.AvaliacaoFisicaModel;
import ferreira.crudrestapidatajpa.models.form.AvaliacaoFisicaForm;
import ferreira.crudrestapidatajpa.models.form.AvaliacaoFisicaUpdateForm;
import ferreira.crudrestapidatajpa.repositories.AlunoRepository;
import ferreira.crudrestapidatajpa.repositories.AvaliacaoFisicaRepository;
import ferreira.crudrestapidatajpa.services.IAvaliacaoFisicaService;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

  @Autowired
  private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

  @Autowired
  private AlunoRepository alunoRepository;

  @Override
  public AvaliacaoFisicaModel create(AvaliacaoFisicaForm form) {

    AvaliacaoFisicaModel avaliacaoFisica = new AvaliacaoFisicaModel();

    AlunoModel aluno = alunoRepository.findById(form.getAlunoId())
        .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

    avaliacaoFisica.setAluno(aluno);
    avaliacaoFisica.setPeso(form.getPeso());
    avaliacaoFisica.setAltura(form.getAltura());

    return avaliacaoFisicaRepository.save(avaliacaoFisica);

  }

  @Override
  public AvaliacaoFisicaModel getById(UUID id) {
    return avaliacaoFisicaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));
  }

  @Override
  public List<AvaliacaoFisicaModel> getAll() {
    return avaliacaoFisicaRepository.findAll();
  }

  @Override
  public AvaliacaoFisicaModel update(UUID id, AvaliacaoFisicaUpdateForm formUpdate) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(UUID id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public List<AvaliacaoFisicaModel> getAllByAlunoId(UUID alunoId) {
    AlunoModel aluno = alunoRepository.findById(alunoId)
        .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

    return aluno.getAvaliacoesFisicas();
  }

}
