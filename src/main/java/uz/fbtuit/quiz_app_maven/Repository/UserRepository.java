package uz.fbtuit.quiz_app_maven.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.fbtuit.quiz_app_maven.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//    @Query(value = "select p from User p where phoneNumber = ?1")
//    boolean findExistByname(String phoneNumber);

    boolean existsByPhoneNumber(Integer phoneNumber);
    User findByPhoneNumber(Integer phoneNumber);


}
