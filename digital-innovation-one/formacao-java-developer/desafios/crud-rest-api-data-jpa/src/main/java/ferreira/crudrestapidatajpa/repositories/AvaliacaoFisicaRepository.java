package ferreira.crudrestapidatajpa.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ferreira.crudrestapidatajpa.models.AvaliacaoFisicaModel;

@Repository
public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisicaModel, UUID> {

}