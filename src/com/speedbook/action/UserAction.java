package com.speedbook.action;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.speedbook.dao.Dao;

public class UserAction extends ActionSupport {
	Dao dao;
	@Override
	public String execute() throws Exception {
		BeanFactory bf=new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao=(Dao)bf.getBean("dao");
		return SUCCESS;
	}
	
}
