package com.example.demo.exception;

public class JwtAuthException extends RuntimeException{
	public JwtAuthException(String message) {
		super(message);
	}

}
