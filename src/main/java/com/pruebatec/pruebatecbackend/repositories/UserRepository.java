package com.pruebatec.pruebatecbackend.repositories;

// import java.util.List;

// import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebatec.pruebatecbackend.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // List<User> findAllByName(String name);
}
