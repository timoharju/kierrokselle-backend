package com.timoharju.kierroksellebackend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.timoharju.kierroksellebackend.exceptions.CourseNotFoundException;
import com.timoharju.kierroksellebackend.models.Course;
import com.timoharju.kierroksellebackend.services.CourseService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;


@WebMvcTest(CourseController.class)
public class CourseControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    CourseService courseServ;


    Course COURSE_1 = new Course(1L, "Puolarmaari", 18, 23.35, 22.22, "A1", LocalDateTime.now(), LocalDateTime.now());
    Course COURSE_2 = new Course(2L, "Oittaa", 16, 23.35, 22.22, "A1", LocalDateTime.now(), LocalDateTime.now());
    Course COURSE_3 = new Course(3L, "Vols", 17, 22.351313, 22.22222, "A1", LocalDateTime.now(), LocalDateTime.now());

    @Test
    public void can_getAllCourses() throws Exception {
        List<Course> courses = new ArrayList<>(Arrays.asList(COURSE_1, COURSE_2, COURSE_3));

        when(courseServ.getAllCourses()).thenReturn(courses);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/courses")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].courseName", is("Vols")));
    }

    @Test
    public void successfully_getCourseById() throws Exception {
        when(courseServ.getCourse(COURSE_1.getId())).thenReturn(COURSE_1);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/courses/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.courseName", is("Puolarmaari")));
    }

    @Test
    public void successfully_createCourse() throws Exception {
        Course course = Course.builder()
                .courseName("Puolarmaari")
                .holeCount(18)
                .lat(63.2255)
                .lon(20.25252)
                .createdAt(LocalDateTime.now())
                .build();

        when(courseServ.createCourse(course)).thenReturn(course);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/v1/courses")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(course));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.courseName", is("Puolarmaari")));
    }

    @Test
    public void successfully_updateCourse() throws Exception {
        Course updatedCourse = Course.builder()
                .id(1L)
                .courseName("Veikkola")
                .holeCount(18)
                .lon(65.22)
                .lat(25.4242)
                .courseDifficulty("A1")
                .build();

        when(courseServ.updateCourse(updatedCourse, COURSE_1.getId())).thenReturn(updatedCourse);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/api/v1/courses/" + updatedCourse.getId().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(updatedCourse));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.courseName", is("Veikkola")));
    }

    @Test
    public void CourseNotFound_updateCourse() throws Exception {
        Course updatedCourse = Course.builder()
                .id(1L)
                .courseName("Veikkola")
                .holeCount(18)
                .lon(65.22)
                .lat(25.4242)
                .courseDifficulty("A1")
                .build();

      doThrow(new CourseNotFoundException()).when(courseServ).updateCourse(updatedCourse, updatedCourse.getId());

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/api/v1/courses/" + updatedCourse.getId().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(updatedCourse));

        mockMvc.perform(mockRequest)
                .andExpect(status().isNotFound());
    }


}
