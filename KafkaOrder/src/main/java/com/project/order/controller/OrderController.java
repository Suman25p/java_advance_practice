package com.project.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.order.request.OrderRequest;
import com.project.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequest request) {

        orderService.placeOrder(request);

        return ResponseEntity.ok(request.getStatus());
    }
}
