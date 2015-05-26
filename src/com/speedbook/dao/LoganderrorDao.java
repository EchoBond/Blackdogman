package com.speedbook.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.speedbook.daointerface.LoganderrorDaoInterface;
import com.speedbook.model.Loganderror;

public class LoganderrorDao implements LoganderrorDaoInterface {
	private SessionFactory sf;
	private Session sess;
	private Transaction tx;
	public void getSession(){
		sess=sf.openSession();
		tx=sess.beginTransaction();
	}
	//执行并销毁链接
	public void distroy(){
		tx.commit();
		sess.close();
		sf.close();
	}
	
	public void add(Loganderror loganderror){
		getSession();
		sess.save(loganderror);
		distroy();
	}
	public SessionFactory getSf() {
		return sf;
	}
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	
}
