package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	List<Order> findByCustomer_CustomeridAndOrderdateBetween(
			String customerId,
			Date start,
			Date end
				);
}
