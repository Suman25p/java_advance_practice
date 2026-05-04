package com.kodekart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodekart.entity.Cart;
import com.kodekart.entity.Product;
import com.kodekart.repository.CartRepository;
import com.kodekart.repository.ProductRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository repo;

    @Autowired
    private ProductRepository productRepo;

    public void addToCart(int productId, int quantity) {
        Cart cart = new Cart();
        cart.setProductId(productId);
        cart.setQuantity(quantity);
        repo.save(cart);
    }
    public void addToCart(int userId, int productId, int quantity) {

        Cart cart = new Cart();
        cart.setUserId(userId);   // ✅ VERY IMPORTANT
        cart.setProductId(productId);
        cart.setQuantity(quantity);

        repo.save(cart);
    }
    public Iterable<Cart> getCart() {
        return repo.findAll();
    }

    public void clearCart() {
        repo.deleteAll();
    }
    
    public void updateQuantity(int id, int quantity) {
        Cart cart = repo.findById(id).get();
        cart.setQuantity(quantity);
        repo.save(cart);
    }
    
    public double getTotalAmount() {

        double total = 0;

        Iterable<Cart> cartItems = repo.findAll();

        for (Cart c : cartItems) {

            Product p = productRepo.findById(c.getProductId()).get();

            total += p.getPrice() * c.getQuantity();
        }

        return total;
    }

    public List<Cart> getUserCart(int userId) {
        return repo.findByUserId(userId);
    }
}