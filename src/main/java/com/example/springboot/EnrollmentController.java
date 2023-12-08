package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    // Add an enrollment for a student in a course
    @PostMapping("/add")
    public ResponseEntity<Enrollment> addEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment addedEnrollment = enrollmentRepository.save(enrollment);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedEnrollment);
    }

    // List all enrollments based on course
    @GetMapping("/list/course/{courseId}")
    public ResponseEntity<List<Enrollment>> listEnrollmentsByCourse(@PathVariable Long courseId) {
        // Implement logic to get enrollments by course
        List<Enrollment> enrollments = (List<Enrollment>) enrollmentRepository.findEnrollmentByCourseID(courseId);
        return ResponseEntity.ok(enrollments);
    }

    // List all enrollments based on student
    @GetMapping("/list/student/{studentId}")
    public ResponseEntity<List<Enrollment>> listEnrollmentsByStudent(@PathVariable Long studentId) {
        // Implement logic to get enrollments by student
        List<Enrollment> enrollments = (List<Enrollment>) enrollmentRepository.findEnrollmentByStudentID(studentId);
        return ResponseEntity.ok(enrollments);
    }

    // Modify an enrollment
    @PutMapping("/modify/{id}")
    public ResponseEntity<Enrollment> modifyEnrollment(@PathVariable Long id, @RequestBody Enrollment updatedEnrollment) {
        Enrollment enrollment = enrollmentRepository.findById(id).orElse(null);
        if (enrollment != null) {
            enrollment.setCourseID(updatedEnrollment.getCourseID());
            enrollment.setStudentID(updatedEnrollment.getStudentID());

            Enrollment modifiedEnrollment = enrollmentRepository.save(enrollment);
            return ResponseEntity.ok(modifiedEnrollment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an enrollment
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEnrollment(@PathVariable Long id) {
        if (enrollmentRepository.existsById(id)) {
            enrollmentRepository.deleteById(id);
            return ResponseEntity.ok("Enrollment deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
