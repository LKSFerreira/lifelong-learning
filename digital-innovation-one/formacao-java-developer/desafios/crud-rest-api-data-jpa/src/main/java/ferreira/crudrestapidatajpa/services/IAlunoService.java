package ferreira.crudrestapidatajpa.services;

import java.util.List;
import java.util.UUID;

import ferreira.crudrestapidatajpa.models.AlunoModel;
import ferreira.crudrestapidatajpa.models.form.AlunoForm;
import ferreira.crudrestapidatajpa.models.form.AlunoUpdateForm;

public interface IAlunoService {
  /**
   * Cria um Aluno e salva no banco de dados.
   * @param form - formulário referente aos dados para criação de um Aluno no banco de dados.
   * @return - Aluno recém-criado.
   */
  AlunoModel create(AlunoForm form);

  /**
   * Retorna um Aluno que está no banco de dados de acordo com seu Id.
   * @param id - id do Aluno que será exibido.
   * @return - Aluno de acordo com o Id fornecido.
   */
  AlunoModel get(UUID id);

  /**
   * Retorna todos os Alunos que estão no banco de dados.
   * @return - Uma lista os Alunos que estão salvas no DB.
   */
  List<AlunoModel> getAll(String dataNascimento);

  /**
   * Atualiza o Aluno.
   * @param id - id do Aluno que será atualizado.
   * @param formUpdate - formulário referente aos dados necessários para atualização do Aluno
   * no banco de dados.
   * @return - Aluno recém-atualizado.
   */
  AlunoModel update(UUID id, AlunoUpdateForm formUpdate);

  /**
   * Deleta um Aluno específico.
   * @param id - id do Aluno que será removido.
   */
  void delete(UUID id);
}
