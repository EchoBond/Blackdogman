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
	public String AddUser(User user){
		dao=getDao();
		dao.add(user);
		return "Add "+user;
	}
	public String DeleteUser(int id){
		dao=getDao();
		dao.delete(id);
		return "Delete with id "+id;
	}
	public String UpdateUser(User user){
		dao=getDao();
		dao.update(user);
		return "Update "+user;
	}
	public String QueryUser(int id){
		dao=getDao();
		dao.Query(id);
		return "Query with id "+id;
	}
}
