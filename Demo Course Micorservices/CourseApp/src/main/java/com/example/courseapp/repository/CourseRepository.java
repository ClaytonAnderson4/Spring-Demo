package com.example.courseapp.repository;

import com.example.courseapp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CourseRepository extends JpaRepository<Course, BigInteger> {
}
