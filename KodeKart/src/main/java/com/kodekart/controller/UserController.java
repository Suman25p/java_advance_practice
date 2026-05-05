package com.kodekart.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.kodekart.entity.User;
import com.kodekart.service.CartService;
import com.kodekart.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private CartService cartService;

    // ✅ Register
    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute User user, Model model) {
        try {
            service.saveUser(user);
            return "login";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }

    // ✅ Login Page
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/doLogin")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        try {
            User user = service.login(email, password);

            session.setAttribute("user", user);

            // ADMIN
            if ("ADMIN".equalsIgnoreCase(user.getRole())) {
                return "redirect:/admin/products";
            }

            // USER
            return "redirect:/";   // 🔥 FIXED

        } catch (Exception e) {
            model.addAttribute("error", "Invalid Credentials");
            return "login";
        }
    }

    // ✅ Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}