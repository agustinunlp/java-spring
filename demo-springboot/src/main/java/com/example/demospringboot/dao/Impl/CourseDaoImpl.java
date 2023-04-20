package com.example.demospringboot.dao.Impl;

import com.example.demospringboot.dao.CourseDao;
import com.example.demospringboot.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Course> findCourses() {
        return mongoTemplate.findAll(Course.class);
    }

    @Override
    public Course findCourseById(String id) {
        return mongoTemplate.findById(id, Course.class);
    }

    @Override
    public void saveCourse(Course course) {
        mongoTemplate.save(course);
    }

    @Override
    public void deleteCourse(Course course) {
        mongoTemplate.remove(course);
    }
}
