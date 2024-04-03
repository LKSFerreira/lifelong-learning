package ferreira.crudrestapidatajpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ferreira.crudrestapidatajpa.models.MatriculaModel;

public interface MatriculaRepository extends JpaRepository<MatriculaModel, Long> {
  List<MatriculaModel> findByAlunoBairro(String bairro);
}
