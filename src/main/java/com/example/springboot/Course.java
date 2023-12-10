package com.example.springboot;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String courseName;
    private String courseNumber;
    private int capacity;

    private String year;

    private String semester;

    private String pid;




    public Long getCourseId() {
        return courseId;
    }



    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseNumber() {return courseNumber;}

    public void setCourseNumber(String courseNumber) {this.courseNumber = courseNumber;}

    public String getCourseName() {
        return courseName;
    }



    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public String getYear() {return year;}

    public void setYear(String year) {this.year = year;}

    public String getSemester() {return semester;}

    public void setSemester(String semester) {this.semester = semester;}

    public String getPid() {return pid;}

    public void setPid(String pid) {this.pid = pid;}

}
