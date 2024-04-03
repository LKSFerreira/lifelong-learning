package ferreira.crudrestapidatajpa.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ferreira.crudrestapidatajpa.models.AlunoModel;
import ferreira.crudrestapidatajpa.models.MatriculaModel;
import ferreira.crudrestapidatajpa.models.form.MatriculaForm;
import ferreira.crudrestapidatajpa.repositories.AlunoRepository;
import ferreira.crudrestapidatajpa.repositories.MatriculaRepository;
import ferreira.crudrestapidatajpa.services.IMatriculaService;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

  @Autowired
  private MatriculaRepository matriculaRepository;

  @Autowired
  private AlunoRepository alunoRepository;

  @Override
  public MatriculaModel create(MatriculaForm form) {
    AlunoModel aluno = alunoRepository.findById(form.getAlunoId())
        .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

    MatriculaModel matricula = new MatriculaModel();
    matricula.setAluno(aluno);

    return matriculaRepository.save(matricula);
  }

  @Override
  public MatriculaModel get(UUID id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'get'");
  }

  @Override
  public List<MatriculaModel> getAll(String bairro) {
    if (bairro != null) {
      return matriculaRepository.findByAlunoBairro(bairro);
    }
    return matriculaRepository.findAll();
  }

  @Override
  public void delete(UUID id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

}
