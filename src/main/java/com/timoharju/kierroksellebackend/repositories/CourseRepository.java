package com.timoharju.kierroksellebackend.repositories;

import com.timoharju.kierroksellebackend.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
