package com.odp297.demo.controller;

import com.odp297.demo.model.User;
import com.odp297.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUser(){
        return  userService.getAllUser();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }
}
