package com.pruebatec.pruebatecbackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pruebatec.pruebatecbackend.models.User;
import com.pruebatec.pruebatecbackend.repositories.UserRepository;

@Service
public class UserServiceImpl implements BaseService<User>{

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User entity) {
       return userRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

   
    
}
