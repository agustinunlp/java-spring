package com.example.demospringboot.dao;

import com.example.demospringboot.domain.Course;

import java.util.List;

public interface CourseDao {

    List<Course> findCourses();

    Course findCourseById(String id);

    void saveCourse(Course course);

    void deleteCourse(Course course);
}
