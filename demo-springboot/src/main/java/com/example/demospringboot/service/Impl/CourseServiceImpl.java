package com.example.demospringboot.service.Impl;

import com.example.demospringboot.dao.CourseDao;
import com.example.demospringboot.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demospringboot.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao dao;

    @Override
    public List<Course> findCourses() {
        return dao.findCourses();
    }

    @Override
    public Course findCourseById(String id) {
        return dao.findCourseById(id);
    }

    @Override
    public void saveCourse(Course course) {
        dao.saveCourse(course);
    }

    @Override
    public void deleteCourse(Course course) {
        dao.deleteCourse(course);
    }
}
