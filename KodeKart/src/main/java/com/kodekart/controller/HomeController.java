package com.kodekart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	 @GetMapping("/")
	    public String home() {
	        return "home";   // home.jsp
	    }
	 
//    @RequestMapping("/")
//    public String home() {
//        return "index"; // index.jsp
//    }
	 
	 @GetMapping("/index")
	 public String index(HttpSession session) {

	     if (session.getAttribute("user") == null) {
	         return "redirect:/login";  
	     }

	     return "index"; 
	 }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/products")
    public String products() {
        return "products";
    }

    @RequestMapping("/cart")
    public String cart() {
        return "cart";
    }

    @RequestMapping("/orders")
    public String orders() {
        return "orders";
    }

    @RequestMapping("/admin/products")
    public String adminProducts() {
        return "admin-products";
    }
}