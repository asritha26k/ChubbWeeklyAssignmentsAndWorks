package com.example.request;

import java.util.Set;

public class OrderRequest {
    public String item;
    public float price;
    public int quantity;

    public String house;
    public String pin;

    public int customerId;          // Many-To-One
    public Set<Integer> productIds; // Many-To-Many
}
