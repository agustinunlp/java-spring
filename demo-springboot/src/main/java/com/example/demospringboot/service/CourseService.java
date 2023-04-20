package com.example.demospringboot.service;

import com.example.demospringboot.domain.Course;

import java.util.List;

public interface CourseService {

    List<Course> findCourses();

    Course findCourseById(String id);

    void saveCourse(Course course);

    void deleteCourse(Course course);
}
