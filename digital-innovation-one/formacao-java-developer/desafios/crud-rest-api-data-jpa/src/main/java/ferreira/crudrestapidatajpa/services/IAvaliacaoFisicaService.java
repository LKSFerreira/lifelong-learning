package ferreira.crudrestapidatajpa.services;

import java.util.List;
import java.util.UUID;

import ferreira.crudrestapidatajpa.models.AvaliacaoFisicaModel;
import ferreira.crudrestapidatajpa.models.form.AvaliacaoFisicaForm;
import ferreira.crudrestapidatajpa.models.form.AvaliacaoFisicaUpdateForm;

public interface IAvaliacaoFisicaService {
  /**
   * Cria uma Avaliação Física e salva no banco de dados.
   * @param form - formulário referente aos dados para criação da Avaliação Física no banco de dados.
   * @return - Avaliação Física recém-criada.
   */
  AvaliacaoFisicaModel create(AvaliacaoFisicaForm form);

  /**
   * Retorna uma Avaliação Física que está no banco de dados de acordo com seu Id.
   * @param id - id da Avaliação Física que será exibida.
   * @return - Avaliação Física de acordo com o Id fornecido.
   */
  AvaliacaoFisicaModel getById(UUID id);

  /**
   * Retorna todas as Avaliações Física que estão no banco de dados.
   * @return - Uma lista com todas as Avaliações Física que estão salvas no DB.
   */
  List<AvaliacaoFisicaModel> getAll();

  /**
   * Retorna uma Avaliação Física que está no banco de dados de acordo com seu Id.
   * @param alunoId - id do Aluno para buscar as Avaliações Físicas.
   * @return - Avaliação Física de acordo com o Id fornecido.
   */
  List<AvaliacaoFisicaModel> getAllByAlunoId(UUID alunoId);

  /**
   * Atualiza a avaliação física.
   * @param id - id da Avaliação Física que será atualizada.
   * @param formUpdate - formulário referente aos dados necessários para atualização da Avaliação
   * Física no banco de dados.
   * @return - Avaliação Física recém-atualizada.
   */
  AvaliacaoFisicaModel update(UUID id, AvaliacaoFisicaUpdateForm formUpdate);

  /**
   * Deleta uma Avaliação Física específica.
   * @param id - id da Avaliação Física que será removida.
   */
  void delete(UUID id);
}
