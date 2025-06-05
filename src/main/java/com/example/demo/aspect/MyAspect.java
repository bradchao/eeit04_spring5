package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	private static Logger log = LoggerFactory.getLogger(MyAspect.class);
	
	
	private long time;
	/*
	 * *, get*, set*, find*
	 * com.example.demo.service.*.*(..) 包含 子package
	 * *(..), login*(..)
	 */
	@Pointcut("execution(* com.example.demo.controller..*(..))")
	public void doControllerMethods() {}
	
	@Before("doControllerMethods()")
	public void doBefore(JoinPoint joinPoint) {
		time = System.currentTimeMillis();
		System.out.println("Before....");
		System.out.println(joinPoint.getSignature().getName());
		log.info("大家好");
	}
	
	@After("doControllerMethods()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("After....");
		System.out.println(joinPoint.getSignature().getName());
		System.out.println(System.currentTimeMillis() - time);
	}
}
