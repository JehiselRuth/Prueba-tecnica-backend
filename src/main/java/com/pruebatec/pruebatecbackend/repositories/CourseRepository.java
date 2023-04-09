package com.pruebatec.pruebatecbackend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebatec.pruebatecbackend.models.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
    Optional<Course> findCourseByName(String courseName);
}
