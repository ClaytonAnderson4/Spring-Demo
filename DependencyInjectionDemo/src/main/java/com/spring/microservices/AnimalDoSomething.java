package com.spring.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// The @Component annotation is telling Spring that this needs
// to be wired up in the application context. So, the spring
// container will create the object for you under the hood.
@Component
public class AnimalDoSomething {

    // Interface
    private final Animal animal;

    // Dependency injection: we are injecting the Animal into
    // the AnimalSpeak class with constructor injection.
    @Autowired
    public AnimalDoSomething(Animal animal) {
        this.animal = animal;
    }

    // This is taking either dog or cat and calling the speak method.
    public void animalSpeak() {
        this.animal.speak();
    }
}
