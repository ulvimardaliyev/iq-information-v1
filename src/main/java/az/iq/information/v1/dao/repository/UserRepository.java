package az.iq.information.v1.dao.repository;

import az.iq.information.v1.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);

    Optional<User> findUserByEmail(String email);

    //Optional<User> findUserByEmailOrUsername(String email, String password);
    Optional<List<User>> findUserByEmailOrUsername(String email, String password);

    //Optional<User> findUserByUsernameAndPassword(String username, String password);
    User findUserByUsernameAndPassword(String username, String password);

    Boolean existsByUsernameOrEmail(String email, String password);
}
