package com.speedbook.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.speedbook.dao.LoganderrorDao;
import com.speedbook.model.Loganderror;

public class LoganderrorService {
	LoganderrorDao dao;
	public LoganderrorDao getDao(){
		LoganderrorDao dao;
		BeanFactory bf=new ClassPathXmlApplicationContext("applicationContext.xml");
		dao=(LoganderrorDao)bf.getBean("loganderrorDao");
		return dao;
	}
	public void AddLog(Loganderror loganderror){
		dao=getDao();
		dao.add(loganderror);
	}
}
