package com.pruebatec.pruebatecbackend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profiles")
public class UserProfile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name = "work_experience")
    private String workExperience;

    @Column(name = "current_course")
    private String currentCourse;

    public UserProfile(String workExperience, String currentCourse) {
        this.workExperience = workExperience;
        this.currentCourse = currentCourse;
    }

    public UserProfile() {
    }

    public long getId() {
        return id;
    }


    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentCourse(String currentCourse) {
        this.currentCourse = currentCourse;
    }

   

}
