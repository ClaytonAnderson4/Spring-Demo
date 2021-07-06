package com.example.coursecatalog.controller;

import com.example.coursecatalog.entity.Course;
import com.example.coursecatalog.entity.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class CatalogController {

    private final EurekaClient client;

    @Autowired
    public CatalogController(EurekaClient client) {
        this.client = client;
    }

    //http://localhost:8002/
    @GetMapping("/")
    @HystrixCommand(fallbackMethod = "displayDefaultHome")
    public String getCatalogHome() {
        RestTemplate restTemplate = new RestTemplate();

        //default mapping for the getCourseAppHome method in the CourseApp CourseController.
        String courseAppURL = "http://localhost:8001/";

        //setting the returned string to the courseAppMessage.
        String courseAppMessage = restTemplate.getForObject(courseAppURL, String.class);

        //Using Eureka Client
//        InstanceInfo instanceInfo = client.getNextServerFromEureka("course-app-service", false);
//        String courseAppURL = instanceInfo.getHomePageUrl();

        //appended the courseAppMessage to the end of the returned string.
        return "Welcome to Pyramid's Course Catalog! " + courseAppMessage;
    }

    @RequestMapping("/catalog")
    @HystrixCommand(fallbackMethod = "displayDefaultHome")
    public String getCatalog() {
        RestTemplate restTemplate = new RestTemplate();
        String courses = "";

        //default mapping for the getCourseAppHome method in the CourseApp CourseController.
        String courseAppURL = "http://localhost:8001/courses/";

        courses = restTemplate.getForObject(courseAppURL,String.class);

        //Using Eureka Client
//        InstanceInfo instanceInfo = client.getNextServerFromEureka("course-app-service", false);
//        String courseAppURL = instanceInfo.getHomePageUrl();
//        courseAppURL = courseAppURL + "/courses";

        //appended the courseAppMessage to the end of the returned string.
        return("Our courses are " + courses);
    }

    @GetMapping("/first")
    @HystrixCommand(fallbackMethod = "displayDefaultHome")
    public String getFirstCourse() {
        RestTemplate restTemplate = new RestTemplate();
        Course course = new Course();
        User user = new User();

        //Mapping to get the first course
        String courseAppURL = "http://localhost:8001/1";

        //Using Eureka Client
//        InstanceInfo instanceInfo = client.getNextServerFromEureka("course-app-service",false);
//        String courseAppURL = instanceInfo.getHomePageUrl();
//        courseAppURL = courseAppURL+"/1";


        course = restTemplate.getForObject(courseAppURL,Course.class);

        //returning the string with the first course name append.
        return "Pyramid's first course is: " + course.getCoursename();

        //Fetching from the user service
//        instanceInfo = client.getNextServerFromEureka("user-app-service",false);
//        String userAppURL = instanceInfo.getHomePageUrl();
//        userAppURL = userAppURL + "/" + course.getCourseid();
//
//        String usersList = restTemplate.getForObject(userAppURL,String.class);
//
//        assert usersList != null;
//        return("Our first course is "
//                + course.getCoursename()
//                + "***** and Enrolled users are ***** "
//                + usersList
//        );
    }

    public String displayDefaultHome() {
        return "Welcome to Pyramid's Course Catalog. Please try again after some time.";
    }
}
