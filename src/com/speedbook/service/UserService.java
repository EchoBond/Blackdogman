package com.speedbook.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.speedbook.dao.Dao;

public class UserService {
	Dao dao;
	public Dao getDao(){
		Dao dao;
		BeanFactory bf=new ClassPathXmlApplicationContext("applicationContext.xml");
		dao=(Dao)bf.getBean("dao");
		return dao;
	}
	public void add(){
		dao=getDao();
		System.out.println("come£¡@");
	}
}
