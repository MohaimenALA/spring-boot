package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/grades", produces = MediaType.APPLICATION_JSON_VALUE)
public class GradesController {

    @Autowired
    private GradesRepository gradesRepository;

    @PostMapping("/add")
    public Grades addGrade(@RequestBody Grades grades) {
        return gradesRepository.save(grades);
    }

    @GetMapping("/list")
    public Iterable<Grades> getGrades() {
        return gradesRepository.findAll();
    }

    @GetMapping("/view/{gid}")
    public Grades findGradesByGid(@PathVariable Integer gid) {
        return gradesRepository.findGradesBygid(gid);
    }

    @GetMapping("/list/course/{courseID}")
    public Iterable<Grades> findGradesByCourseID(@PathVariable Integer courseID) {
        return gradesRepository.findGradesByCourseID(courseID);
    }

    @GetMapping("/list/student/{studentID}")
    public Iterable<Grades> findGradesByStudentID(@PathVariable Integer studentID) {
        return gradesRepository.findGradesByStudentID(studentID);
    }

    @DeleteMapping("/delete/{gid}")
    public String deleteGradeByGid(@PathVariable("gid") Integer gid) {
        gradesRepository.deleteById(gid);
        return "Grade deleted from database";
    }

    @PutMapping("/modify/{gid}")
    public Grades updateGradesByGid(@PathVariable("gid") Integer gid, @RequestBody Grades updatedGrades) {
        Grades grades = gradesRepository.findById(gid)
                .orElseThrow(() -> new ResourceNotFoundException("Grade not found for this id: " + gid));

        // Update the fields
        grades.setStudentID(updatedGrades.getStudentID());
        grades.setCourseID(updatedGrades.getCourseID());
        grades.setGrade(updatedGrades.getGrade());

        return gradesRepository.save(grades);
    }
}
