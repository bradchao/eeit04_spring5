package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerRepository respository;
	
	@GetMapping("/v1/customer/{id}")
	public ResponseEntity<Customer> test1(@PathVariable String id){
		return ResponseEntity.ok(respository.findById(id).orElse(null));
	}
	
	@GetMapping("/v2/customer/{id}")
	public ResponseEntity<Customer> test2(@PathVariable String id){
		Customer c = 
			respository.findByCustomerIdWithOrders(id).orElse(null);
		return ResponseEntity.ok(c);
	}
	
	@GetMapping("/v3/customer/{id}")
	public ResponseEntity<CustomerDto> test3(@PathVariable String id){
		Customer c = 
			respository.findByCustomerIdWithOrders(id).orElse(null);
		
		CustomerDto cDto = new CustomerDto(
				c.getCustomerid(), c.getCompanyName());
		
		return ResponseEntity.ok(cDto);
	}

	
	
}
