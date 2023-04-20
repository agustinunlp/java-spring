package com.example.demospringboot.controller;

import com.example.demospringboot.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demospringboot.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public ResponseEntity<List<Course>> getCourses() {

       List<Course> books = courseService.findCourses();
       ResponseEntity<List<Course>> response = new ResponseEntity<List<Course>>(books, HttpStatus.OK);
       return response;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable(value = "id") String id) {
        ResponseEntity<Course> response;
        Course course = courseService.findCourseById(id);
        if (course != null) {
            response = new ResponseEntity<Course>(course, HttpStatus.OK);
        }
        else {
            response = new ResponseEntity<Course>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @PostMapping(value = "")
    public ResponseEntity<Course> getCourse(Course course) {
        ResponseEntity<Course> response;
        courseService.saveCourse(course);
        response = new ResponseEntity<Course>(course, HttpStatus.OK);
        return response;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable("id") String id) {
        ResponseEntity<String> response;
        Course course = courseService.findCourseById(id);
        if (course != null) {
            courseService.deleteCourse(course);
            response = new ResponseEntity<String>("The course with Id : " + id + " was deleted Successfully!", HttpStatus.OK);
        }
        else {
            response = new ResponseEntity<String>("The course with Id : " + id + " does not exist!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

}