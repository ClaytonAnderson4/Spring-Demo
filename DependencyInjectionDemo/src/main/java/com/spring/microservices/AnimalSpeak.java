package com.spring.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // This is telling Spring that this needs to be wired up in the
           // application context. So, the spring container will create the
           // object for you under the hood.
public class AnimalSpeak {

    // Interface
    private Animal animal;

    // Dependency injection: we are injecting the Animal into
    // the AnimalSpeak class with constructor injection.
    @Autowired
    public AnimalSpeak(Animal animal) {
        this.animal = animal;
    }

    // Default Constructor
    public AnimalSpeak() {
    }


    // This is taking either dog or cat and calling the speak method.
    public void makeAnimalSpeak() {
        this.animal.speak();
    }
}
