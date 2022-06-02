package com.revature.pms.controller;

import com.revature.pms.model.User;
import com.revature.pms.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserServices userService;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return "Successfully logged in using email: " + user.getEmail();
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "Successfully logged out of account..";
    }

}
