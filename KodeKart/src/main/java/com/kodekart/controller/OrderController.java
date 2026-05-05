package com.kodekart.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kodekart.entity.Product;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {
	
	@GetMapping("/placeOrder")
	public String placeOrder(HttpSession session) {

	    List<Product> cart = (List<Product>) session.getAttribute("cart");

	    session.removeAttribute("cart");  

	    return "order-success";
	}
}
