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
@RequestMapping("/api/v1")
public class CourseController {

    private final CourseService courseServ;

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseServ.getAllCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourseById(@PathVariable Long courseId) {
        return courseServ.getCourse(courseId);
    }

    @PostMapping("/course/create")
    public Course createCourse(@RequestBody Course course) {
        return courseServ.createCourse(course);
    }

    @DeleteMapping("/courses/delete/{courseId}")
    public Course deleteCourseById(@PathVariable Long courseId) {
        return courseServ.deleteCourse(courseId);
    }

    @PutMapping("/courses/update/{courseId}")
    public Course updateCourse(@RequestBody Course course, @PathVariable Long courseId) {
        return courseServ.updateCourse(course, courseId);
    }

}
