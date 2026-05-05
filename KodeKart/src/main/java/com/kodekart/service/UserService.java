package com.kodekart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodekart.entity.User;
import com.kodekart.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User login(String email, String password) {
        return repo.findByEmailAndPassword(email, password);
    }

    public void saveUser(User user) {
        User existing = repo.findByEmail(user.getEmail());

        if (existing != null) {
            throw new RuntimeException("Email already registered!");
        }
        repo.save(user);
    }
}