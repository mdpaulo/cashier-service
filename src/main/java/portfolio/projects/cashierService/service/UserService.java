package portfolio.projects.cashierService.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import portfolio.projects.cashierService.domain.entitties.User;
import portfolio.projects.cashierService.exceptions.CashierServiceException;
import portfolio.projects.cashierService.repository.UserRepository;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new CashierServiceException(String.format("User id %d not found", id), 404));
    }

    public User save(User user){
        return repo.save(user);
    }

    public void delete(Long id){
        try{
            this.validateId(id);
            repo.deleteById(id);
        } catch (DataIntegrityViolationException error){
            throw new CashierServiceException("Can't delete user with related orders", 400, error);
        }

    }

    public User update(Long id, User receivedUserData){
        this.validateId(id);
        var userEntity = repo.getReferenceById(id);
        updateData(userEntity, receivedUserData);
        return repo.save(userEntity);
    }

    public void updateData(User entity, User receivedUserData){
        entity.setName(receivedUserData.getName());
        entity.setEmail(receivedUserData.getEmail());
        entity.setPhone(receivedUserData.getPhone());
    }

    private void validateId(Long id){
        if(!repo.existsById(id)){
            final String message = String.format("User id %d not found", id);
            log.error(message);
            throw new CashierServiceException(message, 404);
        }
    }
}
