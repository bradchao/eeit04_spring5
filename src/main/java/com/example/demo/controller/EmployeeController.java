package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeRepository repository;
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> findById(@PathVariable Integer id){
		Employee e = repository.findById(id).orElse(null);
		if (e == null) {
			System.out.println("debug1");
		}
		return ResponseEntity.ok(e);
	}
	
	

}
