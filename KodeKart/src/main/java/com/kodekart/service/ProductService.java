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

    public List<Product> getAll() {
        return repo.findAll();
    }

    public void addProduct(Product p) {
        p.setStatus("ACTIVE");
        repo.save(p);
    }

    public Product getById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void update(Product p) {
        repo.save(p);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public void changeStatus(int id) {
        Product p = repo.findById(id).get();

        if (p.getStatus().equals("ACTIVE"))
            p.setStatus("INACTIVE");
        else
            p.setStatus("ACTIVE");

        repo.save(p);
    }
}