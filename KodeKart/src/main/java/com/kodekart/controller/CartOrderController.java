package com.kodekart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.kodekart.entity.Cart;
import com.kodekart.entity.Product;
import com.kodekart.entity.User;
import com.kodekart.service.ProductService;
import com.kodekart.service.CartService;
import com.kodekart.service.OrderService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartOrderController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;
    
    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id, HttpSession session) {

        List<Product> cart = (List<Product>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        Product p = productService.getById(id);
        cart.add(p);

        session.setAttribute("cart", cart);

        return "redirect:/viewProducts";
    }

    @GetMapping("/cart")
    public String cart(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        List<Cart> cartItems = cartService.getUserCart(user.getId());
        model.addAttribute("cartItems", cartItems);

        return "cart";
    }

    
    @GetMapping("/checkout")
    public String checkout(HttpSession session, Model model) {

        Object user = session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        List<Product> cart = (List<Product>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {
            return "redirect:/cart";
        }

        double total = 0;

        for (Product p : cart) {
            total += p.getPrice();
        }

        model.addAttribute("total", total);

        return "payment";
    }

    
    @PostMapping("/placeOrder")
    public String placeOrder(HttpSession session) {

        List<Product> cart = (List<Product>) session.getAttribute("cart");

        session.removeAttribute("cart");  

        return "order-success";
    }

    
    @GetMapping("/orders")
    public String orderHistory(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "order-history";
    }

    
    @GetMapping("/orderDetails")
    public String orderDetails(Model model) {
        model.addAttribute("items", orderService.getOrderDetails());
        return "order-details";
    }
    
//    @GetMapping("/cart")
//    public String cart(HttpSession session, Model model) {
//
//        User user = (User) session.getAttribute("user");
//
//        if (user == null) {
//            return "redirect:/login";
//        }
//
//        List<Cart> cartItems = cartService.getUserCart(user.getId());
//        model.addAttribute("cartItems", cartItems);
//
//        return "cart";
//    }
    
  
//    @GetMapping("/checkout")
//    public String checkout(HttpSession session, Model model) {
//
//        User user = (User) session.getAttribute("user");
//
//        if (user == null) {
//            return "redirect:/login";
//        }
//
//        double total = cartService.getTotalAmount(user.getId());
//        model.addAttribute("total", total);
//
//        return "payment"; 
//    }
}