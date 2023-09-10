package cinema.application.repository;

import cinema.application.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("FROM User u JOIN FETCH u.roles WHERE u.email = :email")
    Optional<User> getUserByEmail(String email);
}
