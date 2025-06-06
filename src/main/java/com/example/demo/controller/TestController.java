package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.security.CheckJwt;
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
	
	@PostMapping("/login")
	public String login(@RequestParam String email) {
		// 驗證基本的帳號密碼
		
		return JwtTool.createToken(email);
	}
	
	@CheckJwt
	@GetMapping("/member/m1")
	public String getMemberData1() {
		return "很重要的資料1";
	}
	
	@CheckJwt
	@GetMapping("/member/m2")
	public String getMemberData2() {
		return "很重要的資料2";
	}
	
	
}
