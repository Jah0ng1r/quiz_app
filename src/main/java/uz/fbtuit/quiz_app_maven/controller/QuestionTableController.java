package uz.fbtuit.quiz_app_maven.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.fbtuit.quiz_app_maven.Repository.QuestionTableRepository;
import uz.fbtuit.quiz_app_maven.Service.QuestionTableService;
import uz.fbtuit.quiz_app_maven.entity.QuestionTable;

@RestController
@RequestMapping("api/v1/question")
public class QuestionTableController {
    public final QuestionTableService questionervice;
    private final QuestionTableRepository questionTableRepository;

    public QuestionTableController(QuestionTableService questionervice,
                                   QuestionTableRepository questionTableRepository) {
        this.questionervice = questionervice;
        this.questionTableRepository = questionTableRepository;
    }

    @PostMapping("/createQuestion")
    ResponseEntity createUser(@RequestBody QuestionTable questionTable) {

        questionervice.save(questionTable);
        return new ResponseEntity(questionTable, HttpStatus.OK);

    }
}
