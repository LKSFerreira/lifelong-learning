package ferreira.designpatternwithspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ferreira.designpatternwithspring.models.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String> {

}
