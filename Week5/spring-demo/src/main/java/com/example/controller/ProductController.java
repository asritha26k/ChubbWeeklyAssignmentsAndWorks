package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.repository.ProductRepository;
import com.example.request.Product;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    // Add a new product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }

    // Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return (List<Product>) productRepo.findAll();
    }
}
