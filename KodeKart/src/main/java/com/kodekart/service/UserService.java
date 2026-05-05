package com.kodekart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.kodekart.entity.User;
import com.kodekart.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    // ✅ Login (better approach)
    public User login(String email, String password) {

        User user = repo.findByEmail(email);

        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid email or password!");
        }

        return user;
    }

    // ✅ Register (email unique + DB safe)
    public void saveUser(User user) {

        // 🔥 default role
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");
        }

        try {
            repo.save(user);
        } catch (DataIntegrityViolationException e) {
            // DB level duplicate email
            throw new RuntimeException("Email already registered!");
        }
    }

    // ✅ Get by email
    public User getByEmail(String email) {
        return repo.findByEmail(email);
    }

    // ✅ Role check
    public boolean isAdmin(User user) {
        return user != null && "ADMIN".equalsIgnoreCase(user.getRole());
    }
}