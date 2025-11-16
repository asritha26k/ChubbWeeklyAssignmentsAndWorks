package com.example.request;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
    
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //mappedBy means this is not owning side
    //no need to create a separate foreign key column in order table for address, as by order table we can reach address table
    private Address address;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    
    @ManyToMany
    private Set<Product> products = new HashSet<>();


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
	public Customer getCustomer() {
		// TODO Auto-generated method stub
		return customer;
	}
	public void setAddress(Address address) {
	    this.address = address;
	    if (address != null) {
	        address.setOrder(this); // maintain bidirectional relationship
	    }
	}
	public void setCustomer(Customer customer) {
	    this.customer = customer;
	}

	public Set<Product> getProducts() {
	    return products;
	}

	public void setProducts(Set<Product> products) {
	    this.products = products;
	}

	
}
