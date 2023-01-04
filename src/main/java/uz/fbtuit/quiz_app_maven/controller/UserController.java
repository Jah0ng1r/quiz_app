package uz.fbtuit.quiz_app_maven.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fbtuit.quiz_app_maven.Repository.UserRepository;
import uz.fbtuit.quiz_app_maven.Service.UserService;
import uz.fbtuit.quiz_app_maven.entity.User;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    public final UserService userService;
    HashMap<String, String> vallue = new HashMap<>();

    public UserController(UserService userService,
                          UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    HashMap<String, String> value = new HashMap<>();
    private final UserRepository userRepository;


    //Userga keyin token jo`natiladi shu methodda
    @PostMapping("/createUser")
    ResponseEntity createUser(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity(user, HttpStatus.OK);

    }


    //update user
    @PutMapping("/updateUser/{id}")
    ResponseEntity updateUser(@PathVariable("id") Integer id, @RequestBody User user) {

        int i = userService.updateUserReal(user.getPhoneNumber(), user.getNickName(), user.getName(), user.getLastName(), id);

        return new ResponseEntity(i, HttpStatus.UPGRADE_REQUIRED);

    }


    //bu yerga delete hp va starsni ham qo`shish kerak
    @DeleteMapping("/delete/{id}")
    ResponseEntity deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/getAll")
    ResponseEntity getAll() {
        List<User> userList = userService.getAll();

        return new ResponseEntity<>(userList, HttpStatus.OK);

    }


    @GetMapping("/getUserByPhone/{phoneNumber}")
    ResponseEntity getUserByPhone(@PathVariable Integer phoneNumber) {
        return new ResponseEntity<>(userService.findByPhoneNumber(phoneNumber), HttpStatus.OK);

    }
}
