package com.speedbook.dao;

import java.util.List;

import org.hibernate.Query;
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
	
	public void add(User user){
		getSession();
		sess.save(user);
		distroy();
	}
	
	public boolean delete(int id) {
		System.out.println("进入删除 id="+id);
		String sql="delete from User where id="+id;
		Query query=sess.createQuery(sql);
		if(query.executeUpdate()!=0){
			distroy();
			return true;
		}
		else
			return false;
	}

	public boolean update(User user) {
		String sql="update User set name='"+user.getName()+"' where id="+user.getId();
		Query query=sess.createQuery(sql);
		if(query.executeUpdate()!=0){
			distroy();
			return true;
		}
		else
			return false;
	}

	public List<User> Query(int id) {
		System.out.println("进入查询 id="+id);
		String sql="FROM User WHERE id="+id;
		Query query=sess.createQuery(sql);
		List<User> list=query.list();
		return list;
	}
}
