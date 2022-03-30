
package com.timoharju.kierroksellebackend.services;

import com.timoharju.kierroksellebackend.entities.Course;
import com.timoharju.kierroksellebackend.repositories.CourseRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    
    private CourseRepository courseRepo;


    public List<Course> findAllCourses() {
      return courseRepo.findAll();
    }
}
