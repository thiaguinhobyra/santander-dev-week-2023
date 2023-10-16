package dio.service;

import dio.domain.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);
    List<User> findAllUsers();
    User create(User userToCreate);
    User update(Long id, User user);
    User delete(Long id);

}
