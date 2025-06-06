package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.OrderDetailDto;
import com.example.demo.dto.OrderDto;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
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
		Customer c = respository.findById(id).orElse(null);
		
		ArrayList<OrderDto> oDto = new ArrayList<>();
		List<Order> orders = c.getOrders();
		for (Order order: orders) {
			ArrayList<OrderDetailDto> dDto = new ArrayList<>();
			for (OrderDetail detail: order.getOrderDetails()) {
				OrderDetailDto dto = new OrderDetailDto(
						detail.getUnitPrice(),
						detail.getQuantity(),
						detail.getProduct().getProductName()
						); 
				dDto.add(dto);
			}
			
			OrderDto dto = new OrderDto(
					order.getOrderid(), 
					order.getOrderdate(),
					dDto
					);
			oDto.add(dto);
		}
		
		CustomerDto cDto = new CustomerDto(
				c.getCustomerid(), 
				c.getCompanyName(),
				oDto
				);
		
		return ResponseEntity.ok(cDto);
	}

	@RequestMapping("/m1")
	public void m1(@RequestParam String account, @RequestParam String cname) {
		System.out.printf("%s : %s\n", account, cname);
	}
	
	
	
}
