package com.pruebatec.pruebatecbackend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name = "coursename")
    private String courseName;

    @Column(name = "courseprice")
    private Float coursePrice;

    public Course(String courseName, Float coursePrice) {
        this.courseName = courseName;
        this.coursePrice = coursePrice;
    }

    public Course() {
    }

    public long getId() {
        return id;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Float getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(Float coursePrice) {
        this.coursePrice = coursePrice;
    }

    
    
}
