package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.repository.CustomerRepository;
import com.example.request.Customer;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepo;

   
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerRepo.save(customer);
    }
}
