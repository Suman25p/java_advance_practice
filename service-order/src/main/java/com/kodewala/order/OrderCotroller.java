package com.kodewala.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.order.request.OrderRequest;
import com.kodewala.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderCotroller {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/place")
	public String placeOrder(@RequestBody OrderRequest request) {
		orderService.placeOrder(request);
		
		return "Order Placed Successfully";
	}
}
