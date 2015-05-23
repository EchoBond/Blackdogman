package com.speedbook.logAspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspect {
	@Pointcut("execution(* com.speedbook.dao.*.*(..))")
	public void myPointcut(){}
	
	@Before(value="myPointcut()")
	public void logBefore(){
		System.out.println("before");
	}
	@After(value="myPointcut()")
	public void after(){
		System.out.println("after");
	}
	
	public void afterReturning(){}
	
	public void afterThrowing(){}
	
}
