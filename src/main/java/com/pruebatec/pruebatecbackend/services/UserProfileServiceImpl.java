package com.pruebatec.pruebatecbackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pruebatec.pruebatecbackend.models.UserProfile;
import com.pruebatec.pruebatecbackend.repositories.UserProfileRepository;

@Service
public class UserProfileServiceImpl implements BaseService <UserProfile>{

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public List<UserProfile> findAll() {
       return userProfileRepository.findAll();
    }

    @Override
    public Page<UserProfile> findAll(Pageable pageable) {
       return userProfileRepository.findAll(pageable);  
    }

    @Override
    public Optional<UserProfile> findById(Long id) {
        return userProfileRepository.findById(id);
    }

    @Override
    public UserProfile save(UserProfile entity) {
       return userProfileRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
       userProfileRepository.deleteById(id);
    }
    
}
