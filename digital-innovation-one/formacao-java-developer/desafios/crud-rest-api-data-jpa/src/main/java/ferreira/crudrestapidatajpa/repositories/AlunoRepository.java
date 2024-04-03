package ferreira.crudrestapidatajpa.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ferreira.crudrestapidatajpa.models.AlunoModel;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, UUID> {
  List<AlunoModel> findByDataNascimento(LocalDate dataNascimento);

}
