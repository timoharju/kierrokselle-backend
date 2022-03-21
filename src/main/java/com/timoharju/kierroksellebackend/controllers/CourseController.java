package com.timoharju.kierroksellebackend.controllers;

import com.timoharju.kierroksellebackend.entities.Course;
import com.timoharju.kierroksellebackend.repositories.CourseRepository;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    private final CourseRepository courseRepo;

    public CourseController(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    @GetMapping("/api/courses")
    public List<Course> getCourses() {
        return courseRepo.findAll();
    }

    @GetMapping("/api/courses/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseRepo.findById(id).orElse(null);
    }
    
    @DeleteMapping("/api/courses/{id}")
    public Course deleteCourseById(@PathVariable Long id) {
        Course course = courseRepo.findById(id).orElse(null);
        if (course == null) throw new AssertionError();
        courseRepo.delete(course);
        return course;
    }
    
    @PostMapping("/api/courses")
    public Course postCourse(@RequestBody Course course) {
        return courseRepo.save(course);
    }

}
