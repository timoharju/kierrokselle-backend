package com.timoharju.kierroksellebackend.services;

import com.timoharju.kierroksellebackend.models.Course;
import com.timoharju.kierroksellebackend.repositories.CourseRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    @Mock
    private CourseRepository courseRepo;

    @InjectMocks
    private CourseService underTest;

    @Captor
    ArgumentCaptor<Course> courseCaptor;


    Course COURSE_1 = new Course(1L, "Puolarmaari","Espoo", "Osoite 1 A", "", 18, 3.3, 23.35, 22.22, "A1", LocalDateTime.now(), LocalDateTime.now());


    @Test
    void canCreateNewCourse() {
        underTest.createCourse(COURSE_1);
        verify(courseRepo).save(courseCaptor.capture());
        Course capturedCourse = courseCaptor.getValue();
        assertThat(capturedCourse).isEqualTo(COURSE_1);
    }

    @Test
    void CanGetCourseById() {
        underTest.getCourse(COURSE_1.getId());
        assert COURSE_1.getId() != null;
        verify(courseRepo).findById(COURSE_1.getId());
    }

    @Test
    void canGetAllCourses() {
        underTest.getAllCourses();
        verify(courseRepo).findAll();
    }

    @Test
    void canDeleteCourseById() {
        underTest.deleteCourse(COURSE_1.getId());
        assert COURSE_1.getId() != null;
        verify(courseRepo).deleteById(COURSE_1.getId());
    }

}