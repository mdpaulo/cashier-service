package portfolio.projects.cashierService.config;

import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import portfolio.projects.cashierService.domain.entitties.Category;
import portfolio.projects.cashierService.domain.entitties.Order;
import portfolio.projects.cashierService.domain.entitties.OrderItem;
import portfolio.projects.cashierService.domain.entitties.Payment;
import portfolio.projects.cashierService.domain.entitties.Product;
import portfolio.projects.cashierService.domain.entitties.User;
import portfolio.projects.cashierService.domain.enums.OrderStatus;
import portfolio.projects.cashierService.repository.CategoryRepository;
import portfolio.projects.cashierService.repository.OrderItemRepository;
import portfolio.projects.cashierService.repository.OrderRepository;
import portfolio.projects.cashierService.repository.ProductRepository;
import portfolio.projects.cashierService.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777","123124");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(List.of(cat1,cat2,cat3));
        productRepository.saveAll(List.of(p1,p2,p3,p4,p5));

        p1.getCategories().add(cat2);
        p2.getCategories().addAll(List.of(cat1,cat3));
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);
        productRepository.saveAll(List.of(p1,p2,p3,p4,p5));

        userRepository.saveAll(List.of(u1,u2));
        orderRepository.saveAll(List.of(o1,o2,o3));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
        orderItemRepository.saveAll(List.of(oi1,oi2,oi3,oi4));

        Payment pay1 = new Payment(null,Instant.parse("2019-06-20T21:53:07Z"), o1);
        o1.setPayment(pay1);
        orderRepository.save(o1);
    }
}
