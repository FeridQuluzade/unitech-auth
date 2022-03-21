package az.unitech.deveopment.auth.repo;

import az.unitech.deveopment.auth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByDocumentPin(String documentPin);

}