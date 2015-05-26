package com.speedbook.service;

import com.speedbook.dao.LoganderrorDao;
import com.speedbook.model.Loganderror;

public class LoganderrorService {
	LoganderrorDao dao;
	public void AddLog(Loganderror loganderror){
		dao.add(loganderror);
	}
	public LoganderrorDao getDao() {
		return dao;
	}
	public void setDao(LoganderrorDao dao) {
		this.dao = dao;
	}
	
	
}
