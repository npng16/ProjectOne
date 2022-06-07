package com.revature.pms.controller;

import com.revature.pms.dao.CartDAO;
import com.revature.pms.model.Item;
import com.revature.pms.model.User;
import com.revature.pms.services.ItemServices;
import com.revature.pms.services.UserServices;
import com.revature.pms.utilities.GenerateRandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user") //localhost:8080/user
public class UserController {
    boolean result;
    @Autowired
    UserServices userService;

    @Autowired
    ItemServices itemService;
    @Autowired
    CartDAO cartDAO;
    @Autowired
    User user;

    @Autowired
    GenerateRandomNumber randomNumber;

    @GetMapping("/home")    //localhost:8080/user/home
    public String home() {
        double result = randomNumber.getRandomNumber();
        return "***Welcome to my Project 1***\n"
                + user.displayMessage() +
                " and password hashing message is: " + result;
    }

    @GetMapping     //localhost:8080/user   *********** DISPLAY ALL USERS **********
    public ResponseEntity<List<User>> getUsers() {
        ResponseEntity responseEntity = null;
        List<User> users = userService.getUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    //display user by userid
    @GetMapping("{pUserId}")    //localhost:8080/user
    public User getUser(@PathVariable("pUserId") int userId) {
        System.out.println("Fetching details about user by userId: " + userId);
        return user;
    }

    //********** save the user object and "register" them into the database *****************
    @PostMapping("registerUser")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        ResponseEntity responseEntity = null;

        if (userService.isUserExists(user.getUserId())) {
            responseEntity = new ResponseEntity<String>("Cannot save because user with user id :"
                    + user.getUserId() + " already exists", HttpStatus.CONFLICT);
        } else {
            result = userService.registerUser(user);
            if (result) {
                responseEntity = new ResponseEntity<String>("Successfully Saved user:"
                        + user.getUserId(), HttpStatus.OK);
            }
        }
        return responseEntity;
    }



    // ******************** DELETE A USER BY ID *************************************
    @DeleteMapping("{pUserId}")
    public String deleteUser(@PathVariable("pUserId") int userId) {
        userService.deleteUser(userId);
        return "Deleting details by userId: " + userId;
    }


    @PutMapping("/addItemToCart/{Id}") //localhost:8080/user
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("Id") int id) {
        boolean result = userService.updateUser(user, id);
        ResponseEntity responseEntity = null;
        if(result) {
            responseEntity= new ResponseEntity<String>(user.getName() + " updated successfully!", HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<String>("Cannot update user", HttpStatus.NOT_ACCEPTABLE);
        }
        return responseEntity;

    }

}
