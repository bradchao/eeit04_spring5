package com.example.demo.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.JwtAuthException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(JwtAuthException.class)
	public ResponseEntity<String> handleJwtException(JwtAuthException e) {
		return ResponseEntity.status(HttpStatus.FORBIDDEN)
				.body("權限被拒:" + e.getMessage()); // 403
				
	}
	
	
	
	
}
