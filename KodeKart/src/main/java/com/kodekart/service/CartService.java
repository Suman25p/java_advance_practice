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

    
    public void addToCart(int userId, int productId, int quantity) {

        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setProductId(productId);
        cart.setQuantity(quantity);

        repo.save(cart);
    }

    public List<Cart> getUserCart(int userId) {
        return repo.findByUserId(userId);
    }

    public void clearCart() {
        repo.deleteAll();
    }

    public void updateQuantity(int id, int quantity) {
        Cart cart = repo.findById(id).get();
        cart.setQuantity(quantity);
        repo.save(cart);
    }

   
    public double getTotalAmount(int userId) {

        double total = 0;

        List<Cart> cartItems = repo.findByUserId(userId);

        for (Cart c : cartItems) {
            Product p = productRepo.findById(c.getProductId()).get();
            total += p.getPrice() * c.getQuantity();
        }

        return total;
    }
}