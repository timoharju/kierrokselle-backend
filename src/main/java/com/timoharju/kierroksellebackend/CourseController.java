package com.timoharju.kierroksellebackend;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepo;

    @GetMapping("/api/courses")
    public List<Course> getCourses() {
        return courseRepo.findAll();
    }

    @GetMapping("/api/courses/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseRepo.findById(id).get();
    }
    
    @DeleteMapping("/api/courses/{id}")
    public Course deleteCourseById(@PathVariable Long id) {
        Course course = courseRepo.findById(id).get(); 
        courseRepo.delete(course);
        return course;
    }
    
    @PostMapping("/api/courses")
    public Course postCourse(@RequestBody Course course) {
        return courseRepo.save(course);
    }

}
