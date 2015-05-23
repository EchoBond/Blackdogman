package com.speedbook.dao;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.speedbook.model.User;

public class test {
	public static void main(String[] args) {
		BeanFactory bf=new ClassPathXmlApplicationContext("applicationContext.xml");
		dao dao=(dao)bf.getBean("dao");
		User user=new User();
		user.setLoginid("bdm");
		user.setLoginpwd("bdm");
		user.setName("Blackdogman");
		dao.dao(user);
	}
}
