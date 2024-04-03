package ferreira.webapi.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ferreira.webapi.models.UserModel;


public interface IUserRepository extends JpaRepository<UserModel, UUID> {

    Optional<UserModel> findByEmail(String email);

}
