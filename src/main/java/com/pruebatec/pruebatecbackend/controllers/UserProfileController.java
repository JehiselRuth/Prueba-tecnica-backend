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

import com.pruebatec.pruebatecbackend.models.UserProfile;
import com.pruebatec.pruebatecbackend.services.UserProfileServiceImpl;


@RestController
@RequestMapping("/api/userprofile")
public class UserProfileController {
    
    @Autowired
    private UserProfileServiceImpl userProfileService;

    @Transactional
    @PostMapping(value = "")
    public ResponseEntity<?> create(@RequestBody UserProfile userProfile) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userProfileService.save(userProfile));
    }

    @Transactional
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        Optional<UserProfile> oUserProfile = userProfileService.findById(id);
        if (!oUserProfile.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oUserProfile);
    }

    @Transactional
    @GetMapping
    public List<UserProfile> getAll() {
        return userProfileService.findAll();
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody UserProfile userProfileDetails, @PathVariable Long id) {
        Optional<UserProfile> userProfile = userProfileService.findById(id);
        if (!userProfile.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        userProfile.get().setWorkExperience(userProfileDetails.getWorkExperience());
        userProfile.get().setCurrentCourse(userProfileDetails.getCurrentCourse());
        return ResponseEntity.status(HttpStatus.CREATED).body(userProfileService.save(userProfile.get()));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!userProfileService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        userProfileService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
