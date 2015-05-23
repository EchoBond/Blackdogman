package com.speedbook.dao;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		BeanFactory bf=new ClassPathXmlApplicationContext("applicationContext.xml");
		dao dao=(dao)bf.getBean("dao");
		dao.dao();
	}
}
