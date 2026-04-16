package com.zepto.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zepto.product.entity.ProductEntity;
import com.zepto.product.request.ProductRequest;
import com.zepto.product.response.ProductResponse;
import com.zepto.product.service.IProductService;

@Controller
public class ProductController {

	@Autowired
	IProductService iProductService;

	@PostMapping("uploadProduct")
	public String uploadProduct(@ModelAttribute ProductRequest productRequest, Model model) {

		// Calling service layer
		ProductResponse productResponse = iProductService.createProduct(productRequest);

		model.addAttribute("response", productResponse);

		return "product-confirm";
	}
	
	@GetMapping("getAllProducts")
	public String getAllProducts(@RequestParam(defaultValue = "1") int page,
	                            Model model) {

	    int size = 5; // 5 products per page

	    List<ProductEntity> list = iProductService.getProductsWithPagination(page, size);

	    model.addAttribute("products", list);
	    model.addAttribute("currentPage", page);

	    return "product-list";
	}
	
	@GetMapping("updateStatus")
	public String updateStatus(@RequestParam("productId") int productId,
	                           @RequestParam("status") String status) {

	    iProductService.updateProductStatus(productId, status);

	    return "product-update-success";
	}
	
	@GetMapping("deleteProduct")
	public String deleteProduct(@RequestParam("productId") int productId) {

	    iProductService.deleteProduct(productId);

	    return "product-delete-success";
	}
	
	@GetMapping("/")
	public String openIndexPage() {
	    return "index";   // index.jsp
	}
	
	@GetMapping("dashboard")
	public String openDashboard() {
	    return "product-dashboard";
	}
}