package uz.fbtuit.quiz_app_maven.Service;

import org.springframework.stereotype.Service;
import uz.fbtuit.quiz_app_maven.Repository.QuestionTableRepository;
import uz.fbtuit.quiz_app_maven.entity.QuestionTable;

@Service
public class QuestionTableService {
    public final QuestionTableRepository questionTableRepository;

    public QuestionTableService(QuestionTableRepository questionTableRepository) {
        this.questionTableRepository = questionTableRepository;
    }
    public QuestionTable save(QuestionTable question){
        return questionTableRepository.save(question);
    }
}
