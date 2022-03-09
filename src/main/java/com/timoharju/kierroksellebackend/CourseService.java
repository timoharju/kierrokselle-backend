
package com.timoharju.kierroksellebackend;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    
    private CourseRepository courseRepo;


    public List<Course> findAllCourses() {
      return courseRepo.findAll();
    }
}
