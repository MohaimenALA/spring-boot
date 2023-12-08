package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    // Add a particular course
    @PostMapping("/add")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        Course addedCourse = courseRepository.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedCourse);
    }

    // List all courses
    @GetMapping("/list")
    public ResponseEntity<List<Course>> listCourses() {
        List<Course> courses = (List<Course>) courseRepository.findAll();
        return ResponseEntity.ok(courses);
    }

    // View one course based on id
    @GetMapping("/view/{id}")
    public ResponseEntity<Course> viewCourse(@PathVariable Long id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            return ResponseEntity.ok(course);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Modify a course
    @PutMapping("/modify/{id}")
    public ResponseEntity<Course> modifyCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            course.setCourseName(updatedCourse.getCourseName());
            course.setCourseNumber(updatedCourse.getCourseNumber());
            course.setCapacity(updatedCourse.getCapacity());
            course.setYear(updatedCourse.getYear());
            course.setSemester(updatedCourse.getSemester());
            course.setPid(updatedCourse.getPid());

            Course modifiedCourse = courseRepository.save(course);
            return ResponseEntity.ok(modifiedCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a course
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return ResponseEntity.ok("Course deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
