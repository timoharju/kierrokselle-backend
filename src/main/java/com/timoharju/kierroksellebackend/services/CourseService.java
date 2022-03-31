package com.timoharju.kierroksellebackend.services;

import com.timoharju.kierroksellebackend.models.Course;
import com.timoharju.kierroksellebackend.repositories.CourseRepository;
import com.timoharju.kierroksellebackend.exceptions.CourseNotFoundException;
import com.timoharju.kierroksellebackend.exceptions.InvalidRequestException;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CourseService implements ICourseService {


    private final CourseRepository courseRepo;


    @Override
    public Course create(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public Course get(Long id) {
        return courseRepo.findById(id).orElse(null);
    }

    @Override
    public List<Course> list() {
        return courseRepo.findAll();
    }

    @Override
    public Course delete(Long id) {
        Course course = courseRepo.findById(id).orElse(null);
        courseRepo.deleteById(id);
        return course;
    }

    @Override
    public Course update(Course course, Long id) {
        if (course == null || id == null) {
            throw new InvalidRequestException("Course or ID must not be null!");
        }
        Optional<Course> optionalCourse = courseRepo.findById(id);
        if (optionalCourse.isEmpty()) {
                throw new CourseNotFoundException("Course not found!");
        }

        Course existingCourse = courseRepo.getById(id);

        existingCourse.setId(existingCourse.getId());
        existingCourse.setCourseName(course.getCourseName());
        existingCourse.setHoleCount(course.getHoleCount());
        existingCourse.setLat(course.getLat());
        existingCourse.setLon(course.getLon());

        return courseRepo.save(existingCourse);
    }

}
