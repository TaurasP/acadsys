package lt.tauras.acadsys.service;

import lt.tauras.acadsys.model.User;
import lt.tauras.acadsys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_LECTURER = "ROLE_LECTURER";
    public static final String ROLE_STUDENT = "ROLE_STUDENT";

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User getUserById(long id) {
        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException(" Naudotojas nerastas pagal id :: " + id);
        }
        return user;
    }

    @Override
    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);
    }
}
