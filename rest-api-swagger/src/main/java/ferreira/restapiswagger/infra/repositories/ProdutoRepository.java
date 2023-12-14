package ferreira.restapiswagger.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ferreira.restapiswagger.infra.entities.ProdutoEntity;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, String> {

  Boolean existsByNome(String nome);

  ProdutoEntity findByNome(String nome);

  void deleteByNome(String nome);

}
