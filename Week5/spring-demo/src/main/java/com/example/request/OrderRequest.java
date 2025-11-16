package com.example.request;

import java.util.List;

public class OrderRequest {
	public String item;
	public float price;
	public int quantity;

	public String house;
	public String pin;

	public int customerId;
	public List<Integer> productIds;
}
