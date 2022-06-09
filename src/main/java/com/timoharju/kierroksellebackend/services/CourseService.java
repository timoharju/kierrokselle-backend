package com.timoharju.kierroksellebackend.services;

import com.timoharju.kierroksellebackend.exceptions.DuplicateCourseException;
import com.timoharju.kierroksellebackend.models.Course;
import com.timoharju.kierroksellebackend.repositories.CourseRepository;
import com.timoharju.kierroksellebackend.exceptions.CourseNotFoundException;
import com.timoharju.kierroksellebackend.exceptions.InvalidRequestException;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class CourseService implements ICourseService {

    private final CourseRepository courseRepo;


    @Override
    public Course createCourse(Course course) {
        if (courseRepo.findByCourseName(course.getCourseName()) == null) {
            return courseRepo.save(course);
        }
        throw new DuplicateCourseException("Course with that name already exists.");
    }

    @Override
    public Course getCourse(Long id) {
        return courseRepo.findById(id).orElse(null);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Course deleteCourse(Long id) {
        Course course = courseRepo.findById(id).orElse(null);
        courseRepo.deleteById(id);
        return course;
    }

    @Transactional
    @Override
    public Course updateCourse(Course course, Long id) {
        if (course == null || id == null) {
            throw new InvalidRequestException("Course or ID must not be null.");
        }
        Optional<Course> optionalCourse = courseRepo.findById(id);
        if (optionalCourse.isEmpty()) {
                throw new CourseNotFoundException("Course not found.");
        }

        Course existingCourse = courseRepo.getById(id);

        existingCourse.setId(existingCourse.getId());
        existingCourse.setCourseName(course.getCourseName());
        existingCourse.setHoleCount(course.getHoleCount());
        existingCourse.setLat(course.getLat());
        existingCourse.setLon(course.getLon());
        existingCourse.setCourseDifficulty(course.getCourseDifficulty());
        existingCourse.setRating(0);

        return courseRepo.save(existingCourse);
    }

}
