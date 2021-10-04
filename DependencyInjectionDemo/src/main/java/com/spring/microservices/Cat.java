package com.spring.microservices;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// This will tell the container to use this object.
// Otherwise, it will not know which object to use.
@Primary
@Component
public class Cat implements Animal {

    // Cat is implementing Animal so this will give us access
    // to the speak method.
    public void speak() {
        System.out.println("Meow");
    }
}
