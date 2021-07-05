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

        AnimalSpeak killer = new AnimalSpeak();
        Animal animal = new Cat(); //Or cat

        //Injecting dependencies at run time....
//        AnimalSpeak killer = context.getBean(AnimalSpeak.class);
//        Animal animal = context.getBean(Animal.class);

        killer.setAnimal(animal);
        killer.makeAnimalSpeak();

        System.out.println("******************");

    }

}
