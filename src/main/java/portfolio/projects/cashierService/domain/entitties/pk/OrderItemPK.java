package portfolio.projects.cashierService.domain.entitties.pk;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import portfolio.projects.cashierService.domain.entitties.Order;
import portfolio.projects.cashierService.domain.entitties.Product;


@Embeddable
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class OrderItemPK implements Serializable {
    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
