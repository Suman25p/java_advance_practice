package com.kodekart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kodekart.entity.Product;
import com.kodekart.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService service;

 // 👉 Add product form open
    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    // 👉 Save product (🔥 यही method पूछा था)
    @PostMapping("/save")
    public String save(@ModelAttribute Product p) {
        service.addProduct(p);
        return "redirect:/admin/products";
    }

    // 👉 View all products
    @GetMapping("/products")
    public String viewProducts(Model model) {
        model.addAttribute("products", service.getAll());
        return "admin-products";
    }


    // Edit
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", service.getById(id));
        return "edit-product";
    }

    // Update
    @PostMapping("/update")
    public String update(@ModelAttribute Product p) {
        service.update(p);
        return "redirect:/admin/products";
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/admin/products";
    }

    // Status Toggle 🔥
    @GetMapping("/status/{id}")
    public String changeStatus(@PathVariable int id) {
        service.changeStatus(id);
        return "redirect:/admin/products";
    }
    
    @GetMapping("/upload")
    public String uploadPage() {
        return "upload-products"; // upload.jsp
    }
    
    @PostMapping("/uploadCSV")
    public String uploadCSV(@RequestParam("file") MultipartFile file) {
        // CSV logic (already दिया था)
        return "redirect:/admin/products";
    }
}
