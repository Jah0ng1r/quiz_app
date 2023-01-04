package uz.fbtuit.quiz_app_maven.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.fbtuit.quiz_app_maven.Repository.UserRepository;
import uz.fbtuit.quiz_app_maven.entity.User;

import java.util.List;

@Service
public class UserService {
    public final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public void updateUser(User user) {

        userRepository.upateUser(user.getPhoneNumber(), user.getNickName(), user.getName(), user.getLastName(), user.getId());

        if (user.getId() != null) {

//
        }
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public int updateUserReal(Integer phoneNumber, String nickName, String name, String lastName, Integer id) {
        return userRepository.updatePhoneNumberAndNameAndLastNameAndNickNameByAllIgnoreCase(phoneNumber, name, lastName, nickName,id);
    }

    public boolean existsByPhoneNumber(Integer phoneNumber) {
        return userRepository.existsByPhoneNumber(phoneNumber);
    }

    public User findByPhoneNumber(Integer phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    public void update(User user) {
        userRepository
                .findById(user.getId()) // returns Optional<User>
                .ifPresent(user1 -> {
                    user1.setName(user.getName());
                    user1.setLastName(user.getLastName());
                    user1.setPhoneNumber(user.getPhoneNumber());
                    user1.setNickName(user.getNickName());

                    userRepository.save(user1);
                });
    }

}
