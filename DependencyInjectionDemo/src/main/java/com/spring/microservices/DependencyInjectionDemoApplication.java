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

        System.out.println("\nDependency Injection Demo\n");

        //Creating a Dog of type Animal called animal.
        Animal animal = new Dog();
        //Creating AnimalSpeak and passing in a animal.
        AnimalSpeak buck = new AnimalSpeak(animal);
        buck.makeAnimalSpeak();

        System.out.println("******************");

        //Injecting dependencies at run time....
        AnimalSpeak buck1 = context.getBean(AnimalSpeak.class);

        //Since we have multiple components we need to @Primary to let
        //the context know which one to wire up.

        buck1.makeAnimalSpeak();

        System.out.println("******************");

    }

}
