package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Employee;
import com.example.demo.projection.EmployeeProjection;

public interface EmployeeRepository 
	extends JpaRepository<Employee, Integer>{
	
	List<EmployeeProjection> searchByTitleStartingWith(String start);

}
