package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.util.JwtTool;

import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class JwtAspect {
	
	@Around("@annotation(com.example.demo.security.CheckJwt)")
	public Object checkJwt(ProceedingJoinPoint joinPoint) throws Throwable{
		HttpServletRequest req = 
			((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
			.getRequest();
		
		// Authorization: Bearer Token
		String authHeader = req.getHeader("Authorization");
		if (authHeader == null) {
			
		}
		if (authHeader.startsWith("Bearer ")) {
			
		}
		String token = authHeader.substring(7);
		String email = JwtTool.parseToken(token);
		if (email == null) {
			
		}
		System.out.println("Token OK");
		
		return joinPoint.proceed();
	
	}

}
