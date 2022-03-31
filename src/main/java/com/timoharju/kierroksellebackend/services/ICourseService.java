package com.timoharju.kierroksellebackend.services;

import com.timoharju.kierroksellebackend.models.Course;
import java.util.List;

public interface ICourseService {

    Course create(Course course);

    Course get(Long id);

    List<Course> list();

    Course delete(Long id);

    Course update(Course course, Long id);

}
