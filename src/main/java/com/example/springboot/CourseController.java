package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    // Add a particular course
    @PostMapping("/add")
    public void addCourse(@RequestBody Course course) {
        courseRepository.save(course);
    }

    // List all courses
    @GetMapping("/list")
    public List<Course> listCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    // View one course based on id
    @GetMapping("/view/{id}")
    public Course viewCourse(@PathVariable Long id) {
        return courseRepository.findById(id).orElse(null);
    }
}
