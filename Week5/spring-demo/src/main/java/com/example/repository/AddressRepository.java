package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.request.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {

}
