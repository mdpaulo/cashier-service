package portfolio.projects.cashierService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.projects.cashierService.domain.entitties.Product;
import portfolio.projects.cashierService.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> findAll(){
        return repo.findAll();
    }

    public Product findById(Long id){
        return repo.findById(id).get();
    }
}
