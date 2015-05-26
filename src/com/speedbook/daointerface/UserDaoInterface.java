package com.speedbook.daointerface;

import java.util.List;

import com.speedbook.model.User;

public interface UserDaoInterface {
	public void add(User user);
	public boolean delete(int id);
	public boolean update(User user);
	public List<User> Query(int id);
}
