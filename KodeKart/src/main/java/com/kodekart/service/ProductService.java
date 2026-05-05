package com.kodekart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodekart.entity.Product;
import com.kodekart.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    // ✅ Get All Products
    public List<Product> getAll() {
        return repo.findAll();
    }

    // ✅ Add Product (Auto status based on quantity)
    public void addProduct(Product p) {
        setStatusBasedOnQuantity(p);
        repo.save(p);
    }

    // ✅ Get Product By Id
    public Product getById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // ✅ Update Product (Auto status update)
    public void update(Product p) {
        setStatusBasedOnQuantity(p);
        repo.save(p);
    }

    // ✅ Delete Product
    public void delete(int id) {
        repo.deleteById(id);
    }

    // ✅ Manual Toggle (Admin Control)
    public void toggleStatus(int id) {

        Product p = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if ("ACTIVE".equalsIgnoreCase(p.getStatus())) {
            p.setStatus("INACTIVE");
        } else {
            p.setStatus("ACTIVE");
        }

        repo.save(p);
    }

    // ✅ Auto Update Status (can be used anywhere)
    public void updateStatusBasedOnQuantity(int id) {

        Product p = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        setStatusBasedOnQuantity(p);
        repo.save(p);
    }

    // 🔥 Common Method (Reusable Logic)
    private void setStatusBasedOnQuantity(Product p) {

        if (p.getQuantity() > 0) {
            p.setStatus("ACTIVE");
        } else {
            p.setStatus("INACTIVE");
        }
    }

    // ✅ Search Product (Full Validated)
    public List<Product> search(String keyword) {

        // null check
        if (keyword == null) {
            throw new RuntimeException("Search keyword cannot be null!");
        }

        // trim
        keyword = keyword.trim();

        // empty check
        if (keyword.isEmpty()) {
            throw new RuntimeException("Please enter something to search!");
        }

        // DB search
        List<Product> products = repo.findByNameContainingIgnoreCase(keyword);

        // no result
        if (products == null || products.isEmpty()) {
            throw new RuntimeException("Product not available!");
        }

        return products;
    }
}