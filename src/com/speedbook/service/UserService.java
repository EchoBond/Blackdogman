package com.speedbook.service;

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
	public int QueryUser(int id){
		dao.Query(id);
		return id;
	}
	
	public UserDao getDao() {
		return dao;
	}
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	
	
}
