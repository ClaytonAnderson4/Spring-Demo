package com.spring.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;

@SpringBootApplication
public class DependencyInjectionDemoApplication {

    //Entry point for project
    public static void main(String[] args) {
        //The context is like your factory. It manages all your dependencies and more.
        ApplicationContext context = SpringApplication.run(DependencyInjectionDemoApplication.class, args);

        System.out.println("Dependency Injection Demo");

        //Comment this out and uncomment the code below.
        Animal animal = new Dog(); //Or cat
        AnimalSpeak killer = new AnimalSpeak(animal);
        killer.makeAnimalSpeak();


        //Injecting dependencies at run time....
        //The primary annotation on the dog class is how it knows which to wire up.
//        AnimalSpeak killer = context.getBean(AnimalSpeak.class);
//        Animal animal = context.getBean(Animal.class);
//        killer.makeAnimalSpeak();

        System.out.println("******************");

    }

}
