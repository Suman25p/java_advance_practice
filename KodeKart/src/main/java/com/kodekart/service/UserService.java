package com.kodekart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodekart.entity.User;
import com.kodekart.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    // 🔐 Login
    public User login(String email, String password) {
        return repo.findByEmailAndPassword(email, password);
    }

    // 📝 Register User
    public void saveUser(User user) {

        // 🔥 1. Check duplicate email
        User existing = repo.findByEmail(user.getEmail());

        if (existing != null) {
            throw new RuntimeException("Email already registered!");
        }

        // 🔥 2. Save user
        repo.save(user);
    }
}