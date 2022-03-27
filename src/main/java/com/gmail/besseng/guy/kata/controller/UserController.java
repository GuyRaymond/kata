package com.gmail.besseng.guy.kata.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gmail.besseng.guy.kata.model.User;
import com.gmail.besseng.guy.kata.service.UserService;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/getUser/{id}")
    User getUser(@PathVariable Long id) {
        return userService.getById(id);
    }
}
