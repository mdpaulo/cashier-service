package portfolio.projects.cashierService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.projects.cashierService.domain.entitties.Order;
import portfolio.projects.cashierService.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repo;

    public List<Order> findAll(){
        return repo.findAll();
    }

    public Order findById(Long id){
        return repo.findById(id).get();
    }

}
