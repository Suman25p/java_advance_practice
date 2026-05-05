package com.kodekart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.kodekart.entity.Product;
import com.kodekart.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService service;

    // ✅ Add Product Page
    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    // ✅ Save Product
    @PostMapping("/save")
    public String save(@ModelAttribute Product p, Model model) {
        try {
            service.addProduct(p);
            return "redirect:/admin/products";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "add-product";
        }
    }

    // ✅ View All Products
    @GetMapping("/products")
    public String viewProducts(Model model) {
        model.addAttribute("products", service.getAll());
        return "admin-products";
    }

    // ✅ Edit Page
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Product p = service.getById(id);

        if (p == null) {
            return "redirect:/admin/products";
        }

        model.addAttribute("product", p);
        return "edit-product";
    }

    // ✅ Update Product
    @PostMapping("/update")
    public String update(@ModelAttribute Product p, Model model) {
        try {
            service.update(p); // 🔥 auto status update inside service
            return "redirect:/admin/products";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "edit-product";
        }
    }

    // ✅ Delete Product
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/admin/products";
    }

    // ✅ Change Status (Manual Toggle)
    @GetMapping("/status/{id}")
    public String changeStatus(@PathVariable int id) {
        service.toggleStatus(id); // 🔥 updated method name
        return "redirect:/admin/products";
    }

    // ✅ Upload Page (CSV)
    @GetMapping("/upload")
    public String uploadPage() {
        return "upload-products";
    }

    // ✅ Upload CSV (basic structure ready)
    @PostMapping("/uploadCSV")
    public String uploadCSV(@RequestParam("file") MultipartFile file, Model model) {

        if (file.isEmpty()) {
            model.addAttribute("error", "Please select a file!");
            return "upload-products";
        }

        // 🔥 future logic: parse CSV and save products

        return "redirect:/admin/products";
    }
}