package portfolio.projects.cashierService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.projects.cashierService.domain.entitties.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
