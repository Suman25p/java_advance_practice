package com.practice.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.product.request.ProductRequest;
import com.practice.product.request.ProductResponse;
import com.practice.product.service.IProductService;

@Controller
public class ProductController {

	@Autowired
	private IProductService iProductService;
	
	@PostMapping("uploadProduct")
	public String uploadProduct(@ModelAttribute ProductRequest productRequest,Model model)
	{
		ProductResponse productResponse = iProductService.createProduct(productRequest);
		model.addAttribute("response", productResponse);
		return "product-confirm";
	}
}
