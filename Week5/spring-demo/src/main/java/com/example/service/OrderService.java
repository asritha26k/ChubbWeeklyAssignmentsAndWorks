package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.OrderRepository;
import com.example.request.Order;

@Service
public class OrderService {
	//purpose of this service to implement business logic
	//controller is just to handle requests
	@Autowired
	OrderRepository orderRepository;
	public void insertOrder(Order order) {
		System.out.println(order);
	}

}
