package uz.fbtuit.quiz_app_maven.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.fbtuit.quiz_app_maven.entity.QuestionTable;

@Repository
public interface QuestionTableRepository extends JpaRepository<QuestionTable, Integer> {


}
