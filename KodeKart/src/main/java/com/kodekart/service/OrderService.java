package com.kodekart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodekart.entity.*;
import com.kodekart.repository.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private OrderItemRepository itemRepo;

    public void placeOrder() {

        Iterable<Cart> cartItems = cartRepo.findAll();

        Orders order = new Orders();
        order.setOrderDate(LocalDate.now().toString());

        double total = 0;

        for (Cart c : cartItems) {

            Product p = productRepo.findById(c.getProductId()).get();

            double price = p.getPrice() * c.getQuantity();
            total += price;

            
            p.setQuantity(p.getQuantity() - c.getQuantity());
            productRepo.save(p);

            
            OrderItem item = new OrderItem();
            item.setProductId(p.getId());
            item.setQuantity(c.getQuantity());
            item.setPrice(p.getPrice());

            itemRepo.save(item);
        }

        order.setTotalAmount(total);
        orderRepo.save(order);

        
        cartRepo.deleteAll();
    }
    
    public Iterable<Orders> getAllOrders() {
        return orderRepo.findAll();
    }
    
    public List<Map<String, Object>> getOrderDetails() {

        List<Map<String, Object>> result = new ArrayList<>();

        Iterable<OrderItem> items = itemRepo.findAll();

        for (OrderItem item : items) {

            Product p = productRepo.findById(item.getProductId()).get();

            Map<String, Object> map = new HashMap<>();
            map.put("productName", p.getName());
            map.put("price", item.getPrice());
            map.put("quantity", item.getQuantity());

            result.add(map);
        }

        return result;
    }
}