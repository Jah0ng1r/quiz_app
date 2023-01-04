package uz.fbtuit.quiz_app_maven.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.fbtuit.quiz_app_maven.Repository.UserHPAndStarsRepository;
import uz.fbtuit.quiz_app_maven.Service.UserHPAndStrarsService;
import uz.fbtuit.quiz_app_maven.entity.QuestionTable;
import uz.fbtuit.quiz_app_maven.entity.UserHpAndStars;

@RestController
@RequestMapping("api/v1/userhp")
public class HpAndStarsController {
    public final UserHPAndStrarsService userHPAndStrarsService;
    private final UserHPAndStarsRepository userHPAndStarsRepository;

    public HpAndStarsController(UserHPAndStrarsService userHPAndStrarsService,
                                UserHPAndStarsRepository userHPAndStarsRepository) {
        this.userHPAndStrarsService = userHPAndStrarsService;
        this.userHPAndStarsRepository = userHPAndStarsRepository;
    }
    @PostMapping("/createHP")
    ResponseEntity createUser(@RequestBody UserHpAndStars userHpAndStars) {

        userHPAndStrarsService.save(userHpAndStars);
        return new ResponseEntity(userHPAndStarsRepository, HttpStatus.CREATED);

    }
}
