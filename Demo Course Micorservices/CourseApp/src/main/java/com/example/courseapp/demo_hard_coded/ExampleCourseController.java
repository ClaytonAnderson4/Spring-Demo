package com.example.courseapp.demo_hard_coded;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
public class ExampleCourseController {

    @RequestMapping("/example/course")
    public String getCourse() {
        return "My First Course...";
    }

    @RequestMapping("/example/courses")
    public List<ExampleCourse> getCourses(){
        return Arrays.asList(
                new ExampleCourse("100", "course1", "author1"),
                new ExampleCourse("101", "course2", "author2"),
                new ExampleCourse("102", "course3", "author3")
        );
    }

}
