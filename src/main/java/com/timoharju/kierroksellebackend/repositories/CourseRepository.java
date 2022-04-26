package com.timoharju.kierroksellebackend.repositories;

import com.timoharju.kierroksellebackend.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByCourseName(String courseName);
}
