package com.speedbook.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.speedbook.model.User;
import com.speedbook.service.UserService;

public class UserAction extends ActionSupport {
	UserService userService;
	List<User> list;
	String act;
	User user;
	int id;
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		act=request.getParameter("act");
		if(act.equals("query"))
			list=QueryUser(id);
		if(act.equals("delete"))
			DeleteUser(id);
		if(act.equals("add"))
			AddUser(user);
		if(act.equals("update"))
			UpdateUser(user);
		return SUCCESS;
	}
	private List<User> QueryUser(int id){
		List<User> list;
		list=userService.QueryUser(id);
		return list;
	}
	private void DeleteUser(int id){
		userService.DeleteUser(id);
	}
	private void AddUser(User user){
		userService.AddUser(user);
	}
	private void UpdateUser(User user){
		userService.UpdateUser(user);
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public UserService getUserService() {
		return userService;
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	
	
}
