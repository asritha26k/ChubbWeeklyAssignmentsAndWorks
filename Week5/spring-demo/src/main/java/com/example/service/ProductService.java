package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.ProductRepository;
import com.example.request.Product;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepo;

	public Product register(Product product) {
		return productRepo.save(product);

	}

}
