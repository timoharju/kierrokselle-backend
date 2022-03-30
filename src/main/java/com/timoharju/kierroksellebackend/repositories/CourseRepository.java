package com.timoharju.kierroksellebackend.repositories;

import com.timoharju.kierroksellebackend.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
     
    
}
