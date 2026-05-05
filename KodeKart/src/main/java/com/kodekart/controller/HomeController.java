package com.kodekart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kodekart.service.ProductService;


@Controller
public class HomeController {

	@Autowired
    private ProductService productService; 
 
	@GetMapping("/")
    public String index(Model model) {

        model.addAttribute("products", productService.getAll());

        return "index";   // 🔥 MAIN PAGE
    }
    // ✅ Register page
    @GetMapping("/register")
    public String register() {
        return "register";
    }
}