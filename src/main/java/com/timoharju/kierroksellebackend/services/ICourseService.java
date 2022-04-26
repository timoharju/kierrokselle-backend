package com.timoharju.kierroksellebackend.services;

import com.timoharju.kierroksellebackend.models.Course;
import java.util.List;

public interface ICourseService {

    Course createCourse(Course course);

    Course getCourse(Long id);

    List<Course> getAllCourses();

    Course deleteCourse(Long id);

    Course updateCourse(Course course, Long id);

}
