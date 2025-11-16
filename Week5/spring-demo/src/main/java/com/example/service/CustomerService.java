package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.CustomerRepository;
import com.example.request.Customer;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepo;

	public Customer register(Customer customer) {
		return customerRepo.save(customer);
	}

}
