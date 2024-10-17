package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    public User save(User user) {
        if (user == null)
            throw new IllegalArgumentException("User cannot be null!");
        return userRepository.save(user);
    }

    public void delete(User user) {
        if (user == null)
            throw new IllegalArgumentException("User cannot be null!");
        userRepository.delete(user);
    }

    public void deleteById(Long id) {
        if (id == null)
            throw new IllegalArgumentException("ID cannot be null!");
        userRepository.deleteById(id);
    }
}
