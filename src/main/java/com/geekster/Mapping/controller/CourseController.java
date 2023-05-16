package com.geekster.Mapping.controller;

import com.geekster.Mapping.model.Course;
import com.geekster.Mapping.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/addCourse")
    public String addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @GetMapping("/getCourse")
    public List<Course> getAllCourse(@PathVariable Integer courseId){
        return courseService.getAllCourse(courseId);
    }

    @DeleteMapping("/deleteCourse/{courseId}")
    public String deleteCourseById(@PathVariable Integer courseId){
        return courseService.deleteCourseById(courseId);
    }

    @PutMapping("/updateCourse/{courseId}")
    public String updateCourse(@PathVariable Integer courseId , @RequestBody Course course){
        return courseService.updateCourse(courseId , course);
    }
}
