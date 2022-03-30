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

    @GetMapping("/api/v1/courses")
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/api/v1/courses/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseRepo.findById(id).orElse(null);
    }
    
    @DeleteMapping("/api/v1/courses/{id}")
    public Course deleteCourseById(@PathVariable Long id) {
        Course course = courseRepo.findById(id).orElse(null);
        if (course == null) throw new AssertionError();
        courseRepo.delete(course);
        return course;
    }
    
    @PostMapping("/api/v1/courses")
    public Course postCourse(@RequestBody Course course) {
        return courseRepo.save(course);
    }

}
