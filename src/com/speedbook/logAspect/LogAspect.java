package com.speedbook.logAspect;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.speedbook.model.Loganderror;
import com.speedbook.service.LoganderrorService;

@Aspect
public class LogAspect {
	@Pointcut("execution(* com.speedbook.service.UserService.*(..))")
	public void myPointcut(){}
	
	@AfterReturning(value="myPointcut()",returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result){
		String methodName = joinPoint.getSignature().getName();
		LoganderrorService logService=getLogService();
		Loganderror loganderror=new Loganderror();
		loganderror.setType("Log");
		loganderror.setMethod(methodName);
		loganderror.setVaule(result.toString());
		loganderror.setDate(new Date().toString());
		logService.AddLog(loganderror);
	}
	
	@AfterThrowing(value="myPointcut()",throwing="e")
	public void afterThrowing(JoinPoint joinPoint, Exception e){
		String methodName = joinPoint.getSignature().getName();
		LoganderrorService logService=getLogService();
		Loganderror loganderror=new Loganderror();
		loganderror.setType("Error!");
		loganderror.setMethod(methodName);
		loganderror.setVaule(e.getMessage());
		loganderror.setDate(new Date().toString());
		logService.AddLog(loganderror);
	}
	
	private LoganderrorService getLogService(){
		LoganderrorService logService;
		BeanFactory bf=new ClassPathXmlApplicationContext("applicationContext.xml");
		logService=(LoganderrorService)bf.getBean("loganderrorService");
		return logService;
	}
}
