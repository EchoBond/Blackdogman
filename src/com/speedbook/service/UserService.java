package com.speedbook.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.speedbook.dao.UserDao;
import com.speedbook.model.User;

public class UserService {
	UserDao dao;
	public UserDao getDao(){
		UserDao dao;
		BeanFactory bf=new ClassPathXmlApplicationContext("applicationContext.xml");
		dao=(UserDao)bf.getBean("userDao");
		return dao;
	}
	public void AddUser(User user){
		dao=getDao();
		dao.add(user);
	}
	public void DeleteUser(int id){
		dao=getDao();
		dao.delete(id);
	}
	public void UpdateUser(User user){
		dao=getDao();
		dao.update(user);
	}
	public void QueryUser(int id){
		dao=getDao();
		dao.Query(id);
	}
}
