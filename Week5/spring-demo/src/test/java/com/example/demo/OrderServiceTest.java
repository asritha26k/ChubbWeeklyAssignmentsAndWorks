package com.example.demo;


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.repository.CustomerRepository;
import com.example.repository.OrderRepository;
import com.example.repository.ProductRepository;
import com.example.request.Address;
import com.example.request.Customer;
import com.example.request.Order;
import com.example.request.OrderRequest;
import com.example.request.Product;
import com.example.service.OrderService;

class OrderServiceTest {

    @Mock
    private CustomerRepository customerRepo;

    @Mock
    private ProductRepository productRepo;

    @Mock
    private OrderRepository orderRepo;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveOrder_success() {
        // Prepare mock data
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Asritha");

        Product p1 = new Product();
        p1.setId(101);
        p1.setName("Laptop");
        p1.setPrice(50000);

        Product p2 = new Product();
        p2.setId(102);
        p2.setName("Mouse");
        p2.setPrice(500);

        OrderRequest req = new OrderRequest();
        req.item = "Electronics";
        req.price = 50500;
        req.quantity = 1;
        req.house = "123 Street";
        req.pin = "500001";
        req.customerId = 1;
        req.productIds =  (Set<Integer>) Arrays.asList(101, 102);

        // Mock repository behavior
        when(customerRepo.findById(1)).thenReturn(Optional.of(customer));
        when(productRepo.findAllById(req.productIds)).thenReturn(Arrays.asList(p1, p2));
        when(orderRepo.save(any(Order.class))).thenAnswer(i -> i.getArguments()[0]);

        // Call the service
        Order savedOrder = orderService.saveOrder(req);

        // Assertions
        assertNotNull(savedOrder);
        assertEquals("Electronics", savedOrder.getItem());
        assertEquals(50500, savedOrder.getPrice());
        assertEquals(1, savedOrder.getQuantity());
        assertEquals("123 Street", savedOrder.getAddress().getHouse());
        assertEquals("500001", savedOrder.getAddress().getPin());
        assertEquals(customer, savedOrder.getCustomer());
        assertEquals(2, savedOrder.getProducts().size());

        // Verify interactions
        verify(customerRepo).findById(1);
        verify(productRepo).findAllById(req.productIds);
        verify(orderRepo).save(any(Order.class));
    }

    @Test
    void testSaveOrder_customerNotFound() {
        OrderRequest req = new OrderRequest();
        req.customerId = 99;

        when(customerRepo.findById(99)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class, () -> orderService.saveOrder(req));
        assertEquals("Customer not found", ex.getMessage());
    }
}
