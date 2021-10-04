package com.spring.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionDemoApplication {

    // Entry point for project
    public static void main(String[] args) {
        // The context is like your factory. It manages all your dependencies and more.
        // The context is what gets started and run in the background of your spring application.
        ApplicationContext context = SpringApplication.run(DependencyInjectionDemoApplication.class, args);

        System.out.println("\nDependency Injection Demo\n");

        // Creating a Dog or Cat of type Animal.
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        // Creating AnimalSpeak and passing in a dog or cat of type Animal.
        AnimalDoSomething animalDoingSomething = new AnimalDoSomething(myCat);
        animalDoingSomething.makeAnimalSpeak();

        System.out.println("******************");

        // Injecting dependencies at run time....
        // This is letting the container do all the work under the hood.
        AnimalDoSomething myAnimal = context.getBean(AnimalDoSomething.class);

        // Since we have multiple components we need to @Primary to let
        // the context know which one to wire up.
        myAnimal.makeAnimalSpeak();

        System.out.println("******************");

    }

}
