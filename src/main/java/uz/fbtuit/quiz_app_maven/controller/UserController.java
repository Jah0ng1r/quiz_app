package uz.fbtuit.quiz_app_maven.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fbtuit.quiz_app_maven.Repository.UserRepository;
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

    public UserController(UserService userService,
                          UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    HashMap<String, String> value = new HashMap<>();
    private final UserRepository userRepository;

    //    chek user ishlagani yoq
    @PostMapping("/checkUser/")
    ResponseEntity responseEntity(@RequestBody CheckPhone checkPhone) {
        Integer phonenumber = checkPhone.getPhoneNumber();
        List<User> userList = userService.getAll();
        User currentUser = null;

        if (userService.existsByPhoneNumber(phonenumber)) {
            value.clear();
            value.put("phoneNumber", "exsit");
            return new ResponseEntity(value, HttpStatus.CHECKPOINT);
        } else {

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

    @PutMapping("/updateUser/{id}")
    ResponseEntity updateUser(@PathVariable("id") Integer id, @RequestBody User user) {

        int i = userService.updateUserReal(user.getPhoneNumber(), user.getNickName(), user.getName(), user.getLastName(),id );

        return new ResponseEntity(i, HttpStatus.UPGRADE_REQUIRED);

    }

    @GetMapping("/getAll")
    ResponseEntity getAll() {
        List<User> userList = userService.getAll();
        List<Integer> ids = null;
        for (User users : userList) {
            ids.add(users.getId());

        }
        return new ResponseEntity<>(ids, HttpStatus.OK);

    }

    // ## hozir lekin Ishlashi kerak
    @PostMapping("/getUserByPhone")
    ResponseEntity getUserByPhone(@RequestBody Integer phoneNumber) {
        return new ResponseEntity<>(userService.findByPhoneNumber(phoneNumber), HttpStatus.OK);

    }
}
