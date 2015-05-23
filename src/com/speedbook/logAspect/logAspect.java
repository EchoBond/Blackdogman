package com.speedbook.logAspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class logAspect {
	
	@Before("execution(* com.speedbook.dao.*.*(..))")
	public void logBefore(){
		System.out.println("before");
	}
	@After("execution(* com.speedbook.dao.*.*(..))")
	public void after(){
		System.out.println("after");
	}
	
	public void afterReturning(){}
	
	public void afterThrowing(){}
	
}
