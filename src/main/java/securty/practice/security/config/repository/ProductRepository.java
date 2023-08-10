package securty.practice.security.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import securty.practice.security.config.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
