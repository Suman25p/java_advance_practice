package com.zepto.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zepto.product.request.ProductRequest;
import com.zepto.product.request.ProductResponse;

@Controller
public class ProductController {

	@PostMapping("uploadProduct")
	public String uploadProduct(@ModelAttribute ProductRequest productRequest, Model model)
	{
		String name = productRequest.getName();
		String qty = productRequest.getQty();
		String description = productRequest.getDescription();
		String price = productRequest.getPrice();
		String soldBy = productRequest.getSoldby();
		
		System.out.println("Received from Seller: " + name + " " +qty +" " + description + " " + price + " " + soldBy);
		
		String input =name + qty;
		String productId = java.util.UUID.nameUUIDFromBytes(input.getBytes()).toString().replace("-", "").substring(0, 4)
				.toUpperCase();
		ProductResponse productResponse = new ProductResponse();
		productResponse.setProductId(productId);
		productResponse.setConfirmationMsg("Your product has been uoloaded!, It will love on catalog soon.");
		model.addAttribute("response",productResponse);
		return "product-confirm";
	}
}
