package com.example.springboot;
import org.springframework.data.repository.CrudRepository;

public interface EnrollmentRepository extends CrudRepository<Enrollment, Long> {
    Enrollment findEnrollmentByEid(Long eid);
    Iterable<Enrollment> findEnrollmentByCourseID(Long courseID);
    Iterable<Enrollment> findEnrollmentByStudentID(Long studentID);
}

