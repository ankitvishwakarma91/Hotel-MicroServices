package com.softworkshub.userservice.services;


import com.softworkshub.userservice.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServices {



    ResponseEntity<User> createUser(User user);

    ResponseEntity<List<User>> getAllUsers();

    ResponseEntity<User> getUserById(String id);

    ResponseEntity<User> updateUser(User user);

//    ResponseEntity<?> deleteUser(String id);
}
