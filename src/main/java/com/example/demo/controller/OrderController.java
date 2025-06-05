package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;

@RestController
@RequestMapping("/api")
public class OrderController {
	@Autowired
	private OrderRepository repository;
	
	@GetMapping("/orders/{id}/{start}/{end}")
	public ResponseEntity<List<Order>> test1(
			@PathVariable String id,
			@PathVariable String start,
			@PathVariable String end
			){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date sDate = sdf.parse(start);
			Date eDate = sdf.parse(end);
			
			List<Order> orders = repository.findByCustomer_CustomeridAndOrderdateBetween(
					id, sDate, eDate);
			
			return ResponseEntity.ok(orders);
		}catch (Exception e) {
			return ResponseEntity.ok(null);
		}
	}
	
}





