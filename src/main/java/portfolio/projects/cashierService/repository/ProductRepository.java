package portfolio.projects.cashierService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.projects.cashierService.domain.entitties.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
