package com.example.courseapp.controller;

import com.example.courseapp.entity.Course;
import com.example.courseapp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class CourseController {

    private final CourseRepository repository;

    @Autowired
    public CourseController(CourseRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String getCourseAppHome() {
        return "Course APP Home!";
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Course getSpecificCourse(@PathVariable("id") BigInteger id) {
        return repository.getById(id);
    }

    @PostMapping("/create")
    public void saveCourse(@RequestBody Course course) {
        repository.save(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable("id") BigInteger id) {
        repository.deleteById(id);
    }
}
