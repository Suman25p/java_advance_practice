package com.kodekart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.kodekart.entity.Product;
import com.kodekart.service.ProductService;
import com.kodekart.service.OrderService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartOrderController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    // 🛒 Add to Cart (SESSION BASED)
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

    // 🛒 View Cart (GUEST ALLOWED)
    @GetMapping("/cart")
    public String viewCart(HttpSession session, Model model) {

        List<Product> cart = (List<Product>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        model.addAttribute("cartItems", cart);

        return "cart";
    }

    // 💳 Checkout (LOGIN REQUIRED)
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

    // 💳 Place Order
    @PostMapping("/placeOrder")
    public String placeOrder(HttpSession session) {

        List<Product> cart = (List<Product>) session.getAttribute("cart");

        // 👉 save order logic (optional: use orderService)

        session.removeAttribute("cart");  // clear cart

        return "order-success";
    }

    // 📦 Order History
    @GetMapping("/orders")
    public String orderHistory(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "order-history";
    }

    // 📄 Order Details
    @GetMapping("/orderDetails")
    public String orderDetails(Model model) {
        model.addAttribute("items", orderService.getOrderDetails());
        return "order-details";
    }
}