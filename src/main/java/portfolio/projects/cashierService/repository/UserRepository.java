package portfolio.projects.cashierService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.projects.cashierService.domain.entitties.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
