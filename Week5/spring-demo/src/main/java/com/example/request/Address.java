
package com.example.request;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
//Address is dependent on Order
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String house;
	String pin;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)//here order_id is the foreign key column in address table
    @JsonIgnore//to avoid circular reference during serialization
	  Order order;
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public void setOrder(Order order) {
	    this.order = order;
	}
	
}
