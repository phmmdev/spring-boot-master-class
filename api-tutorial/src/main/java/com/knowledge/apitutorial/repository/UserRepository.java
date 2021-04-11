package com.knowledge.apitutorial.repository;

import java.util.List;

import com.knowledge.apitutorial.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByRole(String role);

    List<User> findByRoleAndName(String role, String name);
} 