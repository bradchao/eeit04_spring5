package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.util.JwtTool;

@RestController
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/m1")
	public void m1(@RequestParam String email) {
		String token = JwtTool.createToken(email);
		System.out.println(token);
	}
	@RequestMapping("/m2/{token}")
	public void m2(@PathVariable String token) {
		String email = JwtTool.parseToken(token);
		System.out.println(email);
	}
	
	
}
