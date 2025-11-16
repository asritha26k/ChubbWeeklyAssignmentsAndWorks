package com.example.controller;
import com.example.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.request.Order;
import com.example.request.OrderRequest;
import com.example.service.OrderService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
//this converts this class into a spring bean

@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public Order placeOrder(@RequestBody OrderRequest req) {
        return service.saveOrder(req);
    }
}
