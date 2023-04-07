package com.pruebatec.pruebatecbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebatec.pruebatecbackend.models.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long>{
    
}
