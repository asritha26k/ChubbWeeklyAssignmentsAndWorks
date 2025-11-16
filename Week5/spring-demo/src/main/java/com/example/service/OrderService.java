package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.AddressRepository;
import com.example.repository.CustomerRepository;
import com.example.repository.OrderRepository;
import com.example.repository.ProductRepository;
import com.example.request.Address;
import com.example.request.Customer;
import com.example.request.Order;
import com.example.request.OrderRequest;
import com.example.request.Product;

@Service
public class OrderService {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	AddressRepository addressRepo;

	public Order saveOrder(OrderRequest req) {

		// Convert req → Order entity
		Order order = new Order();
		order.setItem(req.item);
		order.setPrice(req.price);
		order.setQuantity(req.quantity);

		// Address
		Address address = new Address();
		address.setHouse(req.house);
		address.setPin(req.pin);

		address = addressRepo.save(address);

		order.setAddress(address);

		// Customer
		Customer c = customerRepo.findById(req.customerId)
				.orElseThrow(() -> new RuntimeException("Customer not found"));

		order.setCustomer(c);

		List<Product> products = new ArrayList<>();
		productRepo.findAllById(req.productIds).forEach(products::add);
		order.setProducts(products);

		return orderRepo.save(order);
	}
}
