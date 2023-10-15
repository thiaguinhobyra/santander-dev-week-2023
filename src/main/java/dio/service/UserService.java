package dio.service;

import dio.domain.model.User;
import dio.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findById(Long id);
    List<User> findAllUsers();
    User create(User userToCreate);
    User update(Long id, User user);
    User delete(Long id);

}
