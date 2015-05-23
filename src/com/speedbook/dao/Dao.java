package com.speedbook.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.speedbook.model.User;

public class Dao {
	private Configuration conf;
	private ServiceRegistry serviceRegistry;
	private SessionFactory sf;
	private Session sess;
	private Transaction tx;
	//用于获取hibernate链接
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
	public void dao(User user){
		getSession();
		sess.save(user);
		distroy();
	}
}
