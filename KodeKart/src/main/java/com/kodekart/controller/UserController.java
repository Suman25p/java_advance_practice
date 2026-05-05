package com.kodekart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodekart.entity.Cart;
import com.kodekart.entity.User;
import com.kodekart.service.CartService;
import com.kodekart.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private CartService cartService; // ✅ add this

   
    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute User user) {
        service.saveUser(user);
        return "login";
    }

    
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }


//    @PostMapping("/doLogin")
//    public String login(@RequestParam String email,
//                        @RequestParam String password,
//                        HttpSession session,
//                        Model model) {
//
//        User user = service.login(email, password);]
//
//        if (user != null) {
//            session.setAttribute("user", user);
//
//            List<Cart> cartItems = cartService.getUserCart(user.getId());
//
//            if (!cartItems.isEmpty()) {
//                return "redirect:/payment";  
//            } else {
//                return "redirect:/index";     
//            }
//        } else {
//            model.addAttribute("error", "Invalid Credentials");
//            return "login";
//        }
//    }

    @PostMapping("/doLogin")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        User user = service.login(email, password);

        if (user != null) {
            session.setAttribute("user", user);

            List<Cart> cartItems = cartService.getUserCart(user.getId());

            if (!cartItems.isEmpty()) {
                return "redirect:/checkout"; 
            }

            return "redirect:/index"; 
        } else {
            model.addAttribute("error", "Invalid Credentials");
            return "login";
        }
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}