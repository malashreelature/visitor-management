package com.diatoz.visitor.management.controller;

import com.diatoz.visitor.management.entity.User;
import com.diatoz.visitor.management.model.UserModel;
import com.diatoz.visitor.management.service.UserDataService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDataService userService;

    @GetMapping("/alluser")
    @ApiOperation(value="It Is finding all User Data")

    public ResponseEntity<List<User>> getAll() {

        List<User> listOfAll = userService.getAll();
        return new ResponseEntity<List<User>>(listOfAll, HttpStatus.OK);
    }

    @PostMapping("/user")
    @ApiOperation(value="It Is creating new User Data")

    public ResponseEntity<UserModel> CreateUser(@RequestBody User user) {
        UserModel model = new UserModel();
        try {
            if (model != null) {
                model = (UserModel) userService.saveUser(user);
                return new ResponseEntity<>(model, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(model, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(model, HttpStatus.valueOf(500));
        }

    }


    @GetMapping("/user/{userId}")
    @ApiOperation(value="It Is finding User By userId Data")

    public ResponseEntity<UserModel> getById(@PathVariable Long userId) {
        UserModel outputModel = new UserModel();
        try {
            outputModel = this.userService.findById(userId);
            if (outputModel.getErrorMessage().equals("")) {
                return new ResponseEntity<>(outputModel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(outputModel, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(outputModel, HttpStatus.valueOf(500));
        }


    }

    @DeleteMapping("/user/{id}")
    @ApiOperation(value="It Is deleting User By userId Data")
    public ResponseEntity<UserModel> deleteUser(@PathVariable("id") Long userId) {
        UserModel outputModel1 = new UserModel();
        try {
            if (outputModel1 != null) {
                outputModel1 = this.userService.deleteById(userId);
                return new ResponseEntity<>(outputModel1, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(outputModel1, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(outputModel1, HttpStatus.valueOf(500));
        }
    }
}
