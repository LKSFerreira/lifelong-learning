package ferreira.crudrestapidatajpa.services.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ferreira.crudrestapidatajpa.models.AlunoModel;
import ferreira.crudrestapidatajpa.models.form.AlunoForm;
import ferreira.crudrestapidatajpa.models.form.AlunoUpdateForm;
import ferreira.crudrestapidatajpa.repositories.AlunoRepository;
import ferreira.crudrestapidatajpa.services.IAlunoService;

@Service
public class AlunoServiceImpl implements IAlunoService {

  @Autowired
  private AlunoRepository alunoRepository;

  @Override
  public AlunoModel create(AlunoForm form) {

    AlunoModel aluno = new AlunoModel();
    aluno.setNome(form.getNome());
    aluno.setCpf(form.getCpf());
    aluno.setBairro(form.getBairro());
    aluno.setDataNascimento(form.getDataNascimento());

    return alunoRepository.save(aluno);
  }

  @Override
  public AlunoModel get(UUID id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'get'");
  }

  @Override
  public List<AlunoModel> getAll(String dataNascimento) {
    if (dataNascimento != null) {
      return getAllByDataNascimento(dataNascimento);
    }
    return alunoRepository.findAll();
  }

  @Override
  public AlunoModel update(UUID id, AlunoUpdateForm formUpdate) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(UUID id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  public List<AlunoModel> getAllByDataNascimento(String dataNascimento) {
    LocalDate data = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    return alunoRepository.findByDataNascimento(data);
  }

}
