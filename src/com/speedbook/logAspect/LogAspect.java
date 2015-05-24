package com.speedbook.logAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspect {
	@Pointcut("execution(* com.speedbook.service.*.*(..))")
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
	
	@AfterThrowing(value="myPointcut()",throwing="e")
	public void afterThrowing(JoinPoint joinPoint, Exception e){
		String methodName = joinPoint.getSignature().getName();
		String error="The method " + methodName + " occurs excetion:" + e;
	}
}
