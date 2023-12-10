package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ProgramsRepository programsRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private GradesRepository gradesRepository;

    @Override
    public void run(String... args) throws Exception {

        Student student1 = new Student();
        student1.setAddress("444 League");
        student1.setCity("Ioinia");
        student1.setEmail("Jhin@lotr.com");
        student1.setFirstName("Jihn");
        student1.setLastName("Evil");
        student1.setPhone("709-123-4567");
        student1.setPostal("A24 C95");
        studentRepository.save(student1);

        Student student2 = new Student();
        student1.setAddress("123 Sad Street");
        student1.setCity("The Fun");
        student1.setEmail("alawa@rawad.com");
        student1.setFirstName("Rawad");
        student1.setLastName("Alawa");
        student1.setPhone("709-642-9967");
        student1.setPostal("a1h2b3");
        studentRepository.save(student2);



    }
}
