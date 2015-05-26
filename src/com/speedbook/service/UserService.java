package com.speedbook.service;

import com.speedbook.dao.UserDao;
import com.speedbook.model.User;

public class UserService {
	UserDao dao;
	public String AddUser(User user){
		dao.add(user);
		return "Add "+user;
	}
	public String DeleteUser(int id){
		dao.delete(id);
		return "Delete with id "+id;
	}
	public String UpdateUser(User user){
		dao.update(user);
		return "Update "+user;
	}
	public String QueryUser(int id){
		dao.Query(id);
		return "Query with id "+id;
	}
	
	public UserDao getDao() {
		return dao;
	}
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	
	
}
