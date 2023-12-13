package ferreira.restapiswagger.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ferreira.restapiswagger.infra.entities.ProdutoEntity;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, String> {

}
