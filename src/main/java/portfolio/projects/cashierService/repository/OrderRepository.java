package portfolio.projects.cashierService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.projects.cashierService.domain.entitties.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
