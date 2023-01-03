package uz.fbtuit.quiz_app_maven.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.fbtuit.quiz_app_maven.entity.UserHpAndStars;

@Repository
public interface UserHPAndStarsRepository extends JpaRepository<UserHpAndStars, Integer> {
}
