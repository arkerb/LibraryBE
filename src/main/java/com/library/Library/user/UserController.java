package com.library.Library.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "{userId}")
    public User getUserById(@PathVariable("userId") Long userId) {
        return userService.loadUserById(userId);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{userId}")
    public ResponseEntity deleteUserById(@PathVariable("userId") Long userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "")
    public ResponseEntity createNewUser(@RequestBody User user) {
        userService.createNewUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(path = "username/{userName}")
    public List<User> getUsersByUserName(@PathVariable("userName") String userName) {
        return userService.findUsersByUsername(userName);
    }

    @GetMapping(path = "fullName/{fullName}")
    public List<User> getUsersByFullName(@PathVariable("fullName") String fullName) {
        return userService.findUsersByFullName(fullName);
    }


}
