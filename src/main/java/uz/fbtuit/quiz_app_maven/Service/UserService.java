package uz.fbtuit.quiz_app_maven.Service;

import org.springframework.stereotype.Service;
import uz.fbtuit.quiz_app_maven.Repository.UserRepository;
import uz.fbtuit.quiz_app_maven.entity.User;

import java.util.List;

@Service
public class UserService {
    public final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean existsByPhoneNumber(String phoneNumber) {
        return userRepository.existsByPhoneNumber(phoneNumber);
    }

    public User findByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

}
