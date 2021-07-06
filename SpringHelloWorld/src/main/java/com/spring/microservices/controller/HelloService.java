package com.spring.microservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class HelloService {

    //http://localhost:8080/api/v1/
    @GetMapping("/")
    public String index() {
        return "Hello World 2021...";
    }
 }
