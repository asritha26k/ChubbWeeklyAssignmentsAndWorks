package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.request.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
