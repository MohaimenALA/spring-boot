package com.example.springboot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // Add a particular student
    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        try {
            studentRepository.save(student);
            return new ResponseEntity<>("Student added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add student", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // List all students
    @GetMapping("/list")
    public ResponseEntity<List<Student>> listStudents() {
        List<Student> students = (List<Student>) studentRepository.findAll();
        return ResponseEntity.ok(students);
    }


    // View one student based on id
    @GetMapping("/view/{id}")
    public ResponseEntity<Student> viewStudent(@PathVariable Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Modify a student record
    @PutMapping("/modify")
    public ResponseEntity<String> modifyStudent(@RequestBody Student student) {
        try {
            studentRepository.save(student);
            return new ResponseEntity<>("Student modified successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to modify student", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete a student record
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        try {
            studentRepository.deleteById(id);
            return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete student", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
