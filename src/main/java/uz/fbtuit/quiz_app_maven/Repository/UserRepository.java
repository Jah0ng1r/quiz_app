package uz.fbtuit.quiz_app_maven.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.fbtuit.quiz_app_maven.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Modifying
    @Transactional
    @Query("update QuizUser q set q.phoneNumber = :phoneNumber, q.name = :name, q.lastName = :lastName, q.nickName = :nickName where  q.id=:id")
    int updatePhoneNumberAndNameAndLastNameAndNickNameByAllIgnoreCase(@Param("phoneNumber") Integer phoneNumber, @Param("name") String name, @Param("lastName") String lastName, @Param("nickName") String nickName,@Param("id") Integer id);

    //    @Query(value = "select p from User p where phoneNumber = ?1")
//    boolean findExistByname(String phoneNumber);
    @Modifying
    @Transactional
    @Query(value = "update QuizUser u set u.phoneNumber = ?1, u.nickName=?2, u.name=?3,u.lastName = ?4 where u.id = ?5")
    void upateUser(Integer phoneNumber, String nickName, String name, String lastName, Integer id);

    Optional<User> findById(Integer id);

    boolean existsByPhoneNumber(Integer phoneNumber);

    User findByPhoneNumber(Integer phoneNumber);


}
