package portfolio.projects.cashierService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.projects.cashierService.domain.entitties.Category;
import portfolio.projects.cashierService.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public List<Category> findAll(){
        return repo.findAll();
    }

    public Category findById(Long id){
        return repo.findById(id).get();
    }
}
