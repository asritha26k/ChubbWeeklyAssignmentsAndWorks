package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.request.Product;

public interface ProductRepository extends CrudRepository<Product,Integer> {
	
}
