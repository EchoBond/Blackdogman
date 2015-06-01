package com.speedbook.service;

import java.util.ArrayList;
import java.util.List;

import com.speedbook.dao.UserDao;
import com.speedbook.model.User;

public class UserService {
	UserDao dao;
	public String AddUser(User user){
		dao.add(user);
		return user.toString();
	}
	public int DeleteUser(int id){
		dao.delete(id);
		return id;
	}
	public String UpdateUser(User user){
		dao.update(user);
		return user.toString();
	}
	public List<User> QueryUser(int id){
		List<User> list;
		list=dao.Query(id);
		return list;
	}
	
	public UserDao getDao() {
		return dao;
	}
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	
	
}
