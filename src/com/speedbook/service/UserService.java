package com.speedbook.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.speedbook.dao.Dao;

public class UserService {
	Dao dao;
	public void add(){
		BeanFactory bf=new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao=(Dao)bf.getBean("dao");
		System.out.println("come£¡@");
	}
}
