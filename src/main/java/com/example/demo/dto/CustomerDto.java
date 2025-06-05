package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity.Order;

public class CustomerDto {
	private String customerid;
	private String companyName;
	private List<OrderDto> orders;
	
	public CustomerDto(String customerid,
			String companyName,
			List<OrderDto> orders
			) {
		this.customerid = customerid;
		this.companyName = companyName;
		this.orders = orders;
	}
	
	public String getCustomerid() {
		return customerid;
	}
	public String getCompanyName() {
		return companyName;
	}

	public List<OrderDto> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDto> orders) {
		this.orders = orders;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	
}
