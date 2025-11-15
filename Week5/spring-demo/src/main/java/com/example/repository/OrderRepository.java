package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.request.Order;

public interface OrderRepository extends CrudRepository<Order,Integer>{

}
