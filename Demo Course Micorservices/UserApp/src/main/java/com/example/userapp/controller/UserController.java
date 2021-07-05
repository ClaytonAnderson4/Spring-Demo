package com.example.userapp.controller;

import com.example.userapp.entity.User;
import com.example.userapp.repostitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/")
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @RequestMapping("/{id}")
    public List<User> getUsersForACourse(@PathVariable("id")BigInteger id) {
        return userRepository.findBycourseid(id);
    }

}
