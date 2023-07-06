package spring2.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;
import spring2.demo.Models.User;
import spring2.demo.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>("user has been added successfully", HttpStatus.OK);
    }
    @GetMapping("/userWithMostLike")
    public ResponseEntity<User> userWithMostLike(){
        User user = userService.findUserWithMostLike();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
