package uz.fbtuit.quiz_app_maven.Service;

import org.springframework.stereotype.Service;
import uz.fbtuit.quiz_app_maven.Repository.UserHPAndStarsRepository;
import uz.fbtuit.quiz_app_maven.entity.UserHpAndStars;

@Service
public class UserHPAndStrarsService {
    public final UserHPAndStarsRepository userHPAndStarsRepository;

    public UserHPAndStrarsService(UserHPAndStarsRepository userHPAndStarsRepository) {
        this.userHPAndStarsRepository = userHPAndStarsRepository;
    }

    public UserHpAndStars save(UserHpAndStars userHpAndStars) {
        return userHPAndStarsRepository.save(userHpAndStars);
    }
}
