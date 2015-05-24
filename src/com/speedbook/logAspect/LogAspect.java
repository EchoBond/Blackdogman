package com.speedbook.logAspect;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.speedbook.model.Loganderror;
import com.speedbook.service.LoganderrorService;

@Aspect
public class LogAspect {
	@Pointcut("execution(* com.speedbook.service.UserService.*(..))")
	public void myPointcut(){}
	
	@Before(value="myPointcut()")
	public void logBefore(){
	}
	@After(value="myPointcut()")
	public void after(){
	}
	
	@AfterReturning(value="myPointcut()",returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result){
		String methodName = joinPoint.getSignature().getName();
		String log="The method " + methodName + " ends with " + result+" In "+new Date();
		System.out.println(log);
		LoganderrorService logService=getLogService();
		Loganderror loganderror=new Loganderror();
		loganderror.setLog(log);
		logService.AddLog(loganderror);
	}
	
	@AfterThrowing(value="myPointcut()",throwing="e")
	public void afterThrowing(JoinPoint joinPoint, Exception e){
		String methodName = joinPoint.getSignature().getName();
		String error="The method " + methodName + " occurs excetion:" +" In "+new Date();
		System.out.println(error);
		LoganderrorService logService=getLogService();
		Loganderror loganderror=new Loganderror();
		loganderror.setError(error);
		logService.AddLog(loganderror);
	}
	
	private LoganderrorService getLogService(){
		LoganderrorService logService;
		BeanFactory bf=new ClassPathXmlApplicationContext("applicationContext.xml");
		logService=(LoganderrorService)bf.getBean("loganderrorService");
		return logService;
	}
}
