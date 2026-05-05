package com.kodekart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.kodekart.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
    private ProductService productService;

    // ✅ Home Page
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("products", productService.getAll());
        return "home";
    }

    // ✅ View Products (User side)
    @GetMapping
    public String viewProducts(Model model) {
        model.addAttribute("products", productService.getAll());
        return "view-products";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {

        model.addAttribute("products", productService.search(keyword));

        return "home"; // 🔥 home.jsp में result दिखेगा
    }
}