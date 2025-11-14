package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.request.Order;

import jakarta.validation.Valid;

@RestController
//this converts this class into a spring bean

public class OrderController {
	@GetMapping("/order") //this is a unique path
	String getOrder() {
		return "hello";
	}
	@PostMapping("/order")
	float saveOrder(@Valid @RequestBody Order order) {
		float x=order.getPrice()*order.getQuantity();
		return x;
	}

}
