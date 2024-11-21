package com.example.cookingwebsite.repository;

import com.example.cookingwebsite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query method to find a user by their username
    User findByUsername(String username);
}
