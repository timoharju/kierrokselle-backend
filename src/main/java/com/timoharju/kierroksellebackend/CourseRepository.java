package com.timoharju.kierroksellebackend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
     
    
}
