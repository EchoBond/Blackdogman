package com.speedbook.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.speedbook.model.Loganderror;

public class LoganderrorDao {
	private Configuration conf;
	private ServiceRegistry serviceRegistry;
	private SessionFactory sf;
	private Session sess;
	private Transaction tx;
	public void getSession(){
		conf=new Configuration().configure();
		serviceRegistry=new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		sf=conf.buildSessionFactory(serviceRegistry);
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
}
