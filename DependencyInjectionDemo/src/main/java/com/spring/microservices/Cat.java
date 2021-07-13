package com.spring.microservices;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class Cat implements Animal {

    public void speak() {
        System.out.println("Meow");
    }
}
