package com.user.controller;

import com.user.dto.UserDTO;
import com.user.entity.User;
import com.user.repository.UserRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping(value="/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> saveUserContractInfo(@Valid @RequestBody User user){
        return ResponseEntity.ok(userRepository.save(user));
    }
    }
