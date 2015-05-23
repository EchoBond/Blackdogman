package com.speedbook.action;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.speedbook.service.UserService;

public class UserAction extends ActionSupport {
	UserService userService;
	@Override
	public String execute() throws Exception {
		BeanFactory bf=new ClassPathXmlApplicationContext("applicationContext.xml");
		userService=(UserService)bf.getBean("userService");
		userService.add();
		return SUCCESS;
	}
	
}
