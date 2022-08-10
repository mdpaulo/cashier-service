package portfolio.projects.cashierService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.projects.cashierService.domain.entitties.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
