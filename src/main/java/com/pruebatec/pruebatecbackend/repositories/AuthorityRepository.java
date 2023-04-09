package com.pruebatec.pruebatecbackend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pruebatec.pruebatecbackend.models.Authority;
import com.pruebatec.pruebatecbackend.utils.AuthorityName;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Optional<Authority> findByName(AuthorityName name);

}
