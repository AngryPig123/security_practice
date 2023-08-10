package securty.practice.security.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import securty.practice.security.config.entity.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

}
