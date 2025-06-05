package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Customer;

public interface CustomerRepository 
	extends JpaRepository<Customer, String>{
	
	@Query("""
			SELECT c
			FROM Customer c
			WHERE c.customerid = :customerId
			""")
	Optional<Customer> findByCustomerIdWithOrders(
			@Param("customerId") String customerId);
	
}
