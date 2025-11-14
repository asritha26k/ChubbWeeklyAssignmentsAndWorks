package com.example.request;

import jakarta.validation.constraints.Min;

public class Order {
    private String item;
    @Min(value=1)
    private float price;
    @Min(value=1)
    private int quantity;
    private Address address;
    public Address getAddress() {
    			return address;
    }
    public String getItem() {
        return item;
    }
    public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setItem(String item) {
        this.item = item;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
}
