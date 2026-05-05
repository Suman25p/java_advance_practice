package com.kodekart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodekart.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    // ✅ Login
    User findByEmailAndPassword(String email, String password);

    // ✅ Check duplicate email
    User findByEmail(String email);
}