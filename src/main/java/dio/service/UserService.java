package dio.service;

import dio.domain.dto.UserDTO;
import dio.domain.model.User;

import java.util.List;

public interface UserService {

    UserDTO findById(Long id);
    List<User> findAllUsers();
    UserDTO create(UserDTO userDTO);

    UserDTO update(Long id, UserDTO userDTO);
    UserDTO delete(Long id);

}
