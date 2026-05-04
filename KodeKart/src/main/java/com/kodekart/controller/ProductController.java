package com.kodekart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.kodekart.entity.Product;
import com.kodekart.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/products")   // 🔥 base URL
public class ProductController {

    @Autowired
    private ProductService service;

    // 🔹 Home page (optional - better in HomeController)
    @GetMapping("/")
    public String home() {
        return "home";
    }

    // 🔹 View all products
    @GetMapping
    public String viewProducts(Model model) {
        model.addAttribute("products", service.getAll());
        return "view-products";
    }

    // 🔹 Show add product form
    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    // 🔹 Save product
    @PostMapping("/save")
    public String save(@ModelAttribute Product p) {
        service.addProduct(p);
        return "redirect:/products";
    }

    // 🔹 Delete product
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/products";
    }
    
    @GetMapping("/addToCart")
    public String addToCart(@RequestParam int id, HttpSession session) {

        List<Product> cart = (List<Product>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        Product p = service.getById(id);
        cart.add(p);

        session.setAttribute("cart", cart);

        return "redirect:/products";
    }
}