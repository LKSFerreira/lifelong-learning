package ferreira.crudrestapidatajpa.services;

import java.util.List;
import java.util.UUID;

import ferreira.crudrestapidatajpa.models.MatriculaModel;
import ferreira.crudrestapidatajpa.models.form.MatriculaForm;

public interface IMatriculaService {
  /**
   * Cria uma Matrícula e salva no banco de dados.
   * @param form - formulário referente aos dados para criação da Matrícula no banco de dados.
   * @return - Matrícula recém-criada.
   */
  MatriculaModel create(MatriculaForm form);

  /**
   * Retorna uma Matrícula que está no banco de dados de acordo com seu Id.
   * @param id - id da Matrícula que será exibida.
   * @return - Matrícula de acordo com o Id fornecido.
   */
  MatriculaModel get(UUID id);

  /**
   * Retorna todas as Matrículas que estão no banco de dados.
   * @return - uma lista com todas as Matrículas que estão salvas no DB.
   */
  List<MatriculaModel> getAll(String bairro);

  /**
   * Deleta uma Matrícula específica.
   * @param id - id da Matrícula que será removida.
   */
  void delete(UUID id);

}
