package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.request.Customer;
import com.example.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/register/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@PostMapping
	public Customer addCustomer(@Valid @RequestBody Customer customer) {
		return customerService.register(customer);
	}
}
