package com.spring.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnimalSpeak {

    //Interface
    private Animal animal;

    //Dependency injection we are injecting the Animal class into the AnimalSpeak class.
    @Autowired
    public AnimalSpeak(Animal animal) {
        this.animal = animal;
    }

    //Default Constructor
    public AnimalSpeak() {
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void makeAnimalSpeak() {
        this.animal.speak();
    }
}
