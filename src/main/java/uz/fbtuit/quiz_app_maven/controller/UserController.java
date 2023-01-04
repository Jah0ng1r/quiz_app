package uz.fbtuit.quiz_app_maven.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fbtuit.quiz_app_maven.Service.UserService;
import uz.fbtuit.quiz_app_maven.entity.CheckPhone;
import uz.fbtuit.quiz_app_maven.entity.User;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    public final UserService userService;
    HashMap<String, String> vallue = new HashMap<>();

    public UserController(UserService userService) {
        this.userService = userService;
    }

    HashMap<String, String> value = new HashMap<>();

    //    chek user ishlagani yoq
    @PostMapping("/checkUser/")
    ResponseEntity responseEntity(@RequestBody CheckPhone checkPhone) {
        Integer phonenumber = checkPhone.getPhoneNumber();
        List<User> userList = userService.getAll();
        User currentUser = null;

        if(userService.existsByPhoneNumber(phonenumber)){

            value.clear();
            value.put("phoneNumber", "exsit");
            return new ResponseEntity(value, HttpStatus.CHECKPOINT);
        }else {

            value.clear();
            value.put("phoneNumber", "Not exsit");
            return new ResponseEntity(value, HttpStatus.CHECKPOINT);
        }
//        for (User user : userList) {
//            if (user.getPhoneNumber() == phonenumber) {
//                currentUser = user;
//                break;
//            }
//        }
//        if (currentUser!=null) {
//            value.clear();
//            value.put("phoneNumber", "exsit");
//            return new ResponseEntity(value, HttpStatus.CHECKPOINT);
//        } else {
//            value.clear();
//            value.put("phoneNumber", " not exsit");
//            return new ResponseEntity(value, HttpStatus.CHECKPOINT);
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
    ResponseEntity getUserByPhone(@RequestBody Integer phoneNumber) {
        return new ResponseEntity<>(userService.findByPhoneNumber(phoneNumber), HttpStatus.OK);

    }
}
