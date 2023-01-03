package uz.fbtuit.quiz_app_maven.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fbtuit.quiz_app_maven.Service.UserService;
import uz.fbtuit.quiz_app_maven.entity.User;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    HashMap<String, String> value = new HashMap<>();

    //    chek user ishlagani yoq
    @PostMapping("/checkUser")
    ResponseEntity responseEntity(@RequestBody String phoneNumber) {
        List<User> userList = userService.getAll();
        String real = "0000";
        User userreal;
        for (User user : userList) {
            if (user.getPhoneNumber() == phoneNumber)
                real = phoneNumber;
            userreal = user;
        }

        if (real.equals("0000")) {
            value.clear();
            value.put("phoneNumber", "Not exist");
            return new ResponseEntity(value, HttpStatus.OK);

        } else {
            value.clear();
            value.put("phoneNumber", "exist");
            return new ResponseEntity(value, HttpStatus.OK);
        }

//        if (userService.existsByPhoneNumber(phoneNumber) || userService.findByPhoneNumber(phoneNumber) != null) {
//            value.clear();
//            value.put("phoneNumber", "exist");
//            return new ResponseEntity(value, HttpStatus.OK);
//        } else {
//            value.clear();
//            value.put("phoneNumber", "Not exist");
//            return new ResponseEntity(value, HttpStatus.OK);
//        }

    }


    //Userga keyin token jo`natiladi shu methodda
    @PostMapping("/createUser")
    ResponseEntity createUser(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity(user, HttpStatus.OK);

    }

    @GetMapping("/getAll")
    ResponseEntity getAll() {
        List<User> userList = userService.getAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);

    }

    // ## hozir lekin Ishlashi kerak
    @PostMapping("/getUserByPhone")
    ResponseEntity getUserByPhone(@RequestBody String phoneNumber) {
        return new ResponseEntity<>(userService.findByPhoneNumber(phoneNumber), HttpStatus.OK);

    }
}
