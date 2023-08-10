package securty.practice.security.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import securty.practice.security.config.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
