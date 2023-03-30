package com.diatoz.visitor.management.controller;
import com.diatoz.visitor.management.entity.User;
import com.diatoz.visitor.management.service.UserDataService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = "bearerAuth")
public class UserController {

    @Autowired
    UserDataService userService;

    @GetMapping("/user/all")
    public ResponseEntity<List<User>> getAll() {
        List<User> listOfAll = userService.getAll();
        return new ResponseEntity<List<User>>(listOfAll, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user){
        userService.saveuser(user);
        return new ResponseEntity<>("User entity created successfully.", HttpStatus.CREATED);
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }



    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUserById(userId);
        return new ResponseEntity<>("User entity deleted successfully.", HttpStatus.OK);
    }
}

