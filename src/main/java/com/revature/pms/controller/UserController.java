package com.revature.pms.controller;

import com.revature.pms.annotations.Authorized;
import com.revature.pms.model.Role;
import com.revature.pms.model.User;
import com.revature.pms.services.AuthorizationService;
import com.revature.pms.services.UserServices;
import com.revature.pms.utilities.GenerateRandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("user") //localhost:8080/user
public class UserController {
    boolean result;
    @Autowired
    UserServices userService;

    @Autowired
    AuthorizationService authorizationService;
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

    @Authorized(allowedRoles = {Role.ADMIN})
    @GetMapping     //localhost:8080/user   *********** DISPLAY ALL USERS **********
    public ResponseEntity<List<User>> getUsers() {
        ResponseEntity responseEntity = null;
        return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
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



    @Authorized(allowedRoles = {Role.ADMIN})
    // ******************** DELETE A USER BY ID *************************************
    @DeleteMapping("{pUserId}")
    public String deleteUser(@PathVariable("pUserId") int userId) {
        userService.deleteUser(userId);
        return "Deleting details by userId: " + userId;
    }


    @Authorized(allowedRoles = {Role.ADMIN, Role.CUSTOMER, Role.CUSTOMER})
    @PutMapping("/addItemToCart/{Id}") //localhost:8080/user
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("Id") int id) {
        authorizationService.guardByUserId(user.getUserId());

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
