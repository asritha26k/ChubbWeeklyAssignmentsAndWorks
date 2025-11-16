package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.request.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping("/register")
public class ProductController {

	@Autowired
	private ProductService productService;

	// Add a new product
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		return productService.register(product);
	}

}
