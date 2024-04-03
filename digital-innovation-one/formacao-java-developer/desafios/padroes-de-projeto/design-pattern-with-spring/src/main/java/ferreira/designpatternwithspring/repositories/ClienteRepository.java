package ferreira.designpatternwithspring.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ferreira.designpatternwithspring.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

}
