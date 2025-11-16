package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.repository.AddressRepository;
import com.example.repository.CustomerRepository;
import com.example.repository.OrderRepository;
import com.example.repository.ProductRepository;
import com.example.request.Address;
import com.example.request.Customer;
import com.example.request.Order;
import com.example.request.OrderRequest;
import com.example.request.Product;

class OrderServiceTest {

	@Mock
	CustomerRepository customerRepo;

	@Mock
	ProductRepository productRepo;

	@Mock
	OrderRepository orderRepo;

	@Mock
	AddressRepository addressRepo;

	@InjectMocks
	OrderService orderService;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testSaveOrder() {
		OrderRequest req = new OrderRequest();
		req.item = "Laptop";
		req.price = 50000;
		req.quantity = 1;
		req.house = "221B Baker Street";
		req.pin = "560001";
		req.customerId = 10;
		req.productIds = Arrays.asList(1, 2);

		Customer mockCustomer = new Customer();
		mockCustomer.setId(10);

		Product p1 = new Product();
		p1.setId(1);
		Product p2 = new Product();
		p2.setId(2);

		Address mockAddress = new Address();
		mockAddress.setId(100);

		Order savedOrder = new Order();
		savedOrder.setId(200);

		when(customerRepo.findById(10)).thenReturn(Optional.of(mockCustomer));
		when(productRepo.findAllById(req.productIds)).thenReturn(Arrays.asList(p1, p2));
		when(addressRepo.save(any(Address.class))).thenReturn(mockAddress);
		when(orderRepo.save(any(Order.class))).thenReturn(savedOrder);

		Order result = orderService.saveOrder(req);

		verify(addressRepo, times(1)).save(any(Address.class));
		verify(customerRepo, times(1)).findById(10);
		verify(productRepo, times(1)).findAllById(req.productIds);
		verify(orderRepo, times(1)).save(any(Order.class));

		assertNotNull(result);
		assertEquals(200, result.getId());
	}
}
