package com.softworkshub.userservice.controller;


import com.softworkshub.userservice.entity.User;
import com.softworkshub.userservice.services.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServicesImpl userServices;


    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return userServices.createUser(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll(){
        return userServices.getAllUsers();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id){
        return userServices.getUserById(id);
    }

}
