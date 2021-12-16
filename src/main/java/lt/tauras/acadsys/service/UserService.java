package lt.tauras.acadsys.service;

import lt.tauras.acadsys.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(long id);
    void deleteUserById(long id);
    Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
