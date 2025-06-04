package com.example.demo.projection;

import java.util.List;

import com.example.demo.entity.Order;

public interface EmployeeProjection {
	String getLastName();
	String getFirstName();
	List<Order> getOrders();
}
