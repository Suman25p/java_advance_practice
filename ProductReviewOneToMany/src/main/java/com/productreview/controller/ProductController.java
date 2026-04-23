package com.productreview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.productreview.iservice.ProductService;
import com.productreview.request.ProductRequest;
import com.productreview.response.ProductResponse;


@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    // Form open karne ke liye
    @GetMapping("/productPage")
    public String loadPage() {
        return "product-form"; // JSP name
    }

    // Form submit
    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute ProductRequest request, Model model) {

        ProductResponse response = productService.createProduct(request);

        model.addAttribute("response", response);

        return "product-success"; // success JSP
    }
}