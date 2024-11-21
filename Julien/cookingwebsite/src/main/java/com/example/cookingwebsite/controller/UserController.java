package com.example.cookingwebsite.controller;

import com.example.cookingwebsite.model.User;
import com.example.cookingwebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return userService.findByUsername(username);
    }
}
