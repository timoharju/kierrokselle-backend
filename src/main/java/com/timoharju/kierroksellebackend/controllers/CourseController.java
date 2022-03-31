package com.timoharju.kierroksellebackend.controllers;

import com.timoharju.kierroksellebackend.models.Course;
import com.timoharju.kierroksellebackend.services.CourseService;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {


    private final CourseService courseServ;


    @GetMapping
    public List<Course> getAllCourses() {
        return courseServ.list();
    }

    @GetMapping("/{courseId}")
    public Course getCourseById(@PathVariable Long courseId) {
        return courseServ.get(courseId);
    }

    @PostMapping
    public Course postCourse(@RequestBody Course course) {
        return courseServ.create(course);
    }

    @DeleteMapping("/{courseId}")
    public Course deleteCourseById(@PathVariable Long courseId) {
        return courseServ.delete(courseId);
    }

    @PutMapping("/{courseId}")
    public Course updateCourse(@RequestBody Course course, @PathVariable Long courseId) {
        return courseServ.update(course, courseId);
    }

}
