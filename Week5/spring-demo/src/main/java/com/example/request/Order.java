package com.example.request;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
@Entity//this tells spring that this class is an entity and it will be mapped to a table in the database
@Table(name = "orders")//as order is a reserved keyword in sql we are changing the table name to orders
public class Order {
	@Id//this is for primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private
	int id;
	@NotBlank
    private String item;
    @Min(value=1)
    private float price;
    @Min(value=1)
    private int quantity;
   
//    private Address address;
//    public Address getAddress() {
//    			return address;
//    }
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
