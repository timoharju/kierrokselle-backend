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


    Course COURSE_1 = new Course(1L, "Puolarmaari", 18, 23.35, 22.22);


    @Test
    void canCreateNewCourse() {
        underTest.create(COURSE_1);
        verify(courseRepo).save(courseCaptor.capture());
        Course capturedCourse = courseCaptor.getValue();
        assertThat(capturedCourse).isEqualTo(COURSE_1);
    }

    @Test
    void CanGetCourseById() {
        underTest.get(COURSE_1.getId());
        assert COURSE_1.getId() != null;
        verify(courseRepo).findById(COURSE_1.getId());
    }

    @Test
    void canGetAllStudents() {
        underTest.list();
        verify(courseRepo).findAll();
    }

    @Test
    void canDeleteCourseById() {
        underTest.delete(COURSE_1.getId());
        assert COURSE_1.getId() != null;
        verify(courseRepo).deleteById(COURSE_1.getId());
    }

}