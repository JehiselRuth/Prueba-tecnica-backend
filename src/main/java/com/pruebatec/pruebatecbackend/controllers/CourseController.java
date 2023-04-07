package com.pruebatec.pruebatecbackend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatec.pruebatecbackend.models.Course;
import com.pruebatec.pruebatecbackend.services.CourseServiceImpl;

@RestController
@RequestMapping(value = "/api/courses")
public class CourseController {
    
    @Autowired
    private CourseServiceImpl courseService;

    @Transactional
    @PostMapping(value = "")
    public ResponseEntity<?> create(@RequestBody Course course) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.save(course));
    }

    @Transactional
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        Optional<Course> oCourse = courseService.findById(id);
        if (!oCourse.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oCourse);
    }

    @Transactional
    @GetMapping
    public List<Course> getAll() {
        return courseService.findAll();
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Course courseDetails, @PathVariable Long id) {
        Optional<Course> course = courseService.findById(id);
        if (!course.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        course.get().setCourseName(courseDetails.getCourseName());
        course.get().setCoursePrice(courseDetails.getCoursePrice());
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.save(course.get()));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!courseService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        courseService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
