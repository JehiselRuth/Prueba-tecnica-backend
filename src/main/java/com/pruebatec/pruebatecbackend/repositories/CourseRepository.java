package com.pruebatec.pruebatecbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebatec.pruebatecbackend.models.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
    
}
