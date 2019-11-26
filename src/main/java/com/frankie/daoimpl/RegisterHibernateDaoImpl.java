package com.frankie.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.ui.Model;

import com.controller.pojo.user.RegisterUserPojo;
import com.frankie.dao.interf.IRegisterDao;

public class RegisterHibernateDaoImpl implements IRegisterDao {
	
	final static Logger logger=Logger.getLogger(RegisterHibernateDaoImpl.class);
	public void register(RegisterUserPojo rup){
		System.out.println("executing  RegisterHibernateDaoImpl :: register");
		logger.info("executing  RegisterHibernateDaoImpl :: register");
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		  SessionFactory sf=config.buildSessionFactory();
		  
		  Session session=sf.openSession();
		  Transaction tx= session.beginTransaction();
		  session.save(rup);
		  tx.commit();
		  session.close();
		  System.out.println("exit  RegisterHibernateDaoImpl :: register");
		  logger.info("exit  RegisterHibernateDaoImpl :: register");
		}
	public List<RegisterUserPojo> loginUser(String mailid,String pwd){
		
		System.out.println("executing RegisterHibernateDaoImpl::loginUser");
		logger.info("executing RegisterHibernateDaoImpl::loginUser");
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		  SessionFactory sf=config.buildSessionFactory();
		  Session session=sf.openSession();
		  
		  Query userSelectQuery= (Query) session.createQuery("from RegisterUserPojo where mailid= :mailid and password= :pwd");
		  userSelectQuery.setParameter("mailid", mailid);
		  userSelectQuery.setParameter("pwd", pwd);
		  List<RegisterUserPojo> list= userSelectQuery.list();
		  System.out.println("parsing list of rup and printing  to console!!");
			
			System.out.println("exit RegisterHibernateDaoImpl::loginUser");
			logger.info("exit RegisterHibernateDaoImpl::loginUser");
		  return list;
		
	}
	public int deleteUser(String mailid){
		System.out.println("executing RegisterHibernateDaoImpl::deleteUser");
		logger.info("executing RegisterHibernateDaoImpl::deleteUser");
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		  SessionFactory sf=config.buildSessionFactory();
		  
		  Session session=sf.openSession();
		  Transaction tx= session.beginTransaction();
		  
		  Query query = session.createQuery("delete RegisterUserPojo where mailid= :mailid ");
		  query.setParameter("mailid", mailid);
		  int result=query.executeUpdate();
		  tx.commit();
		session.close();
		System.out.println("exit RegisterHibernateDaoImpl::deleteUser");
		logger.info("exit RegisterHibernateDaoImpl::deleteUser");
		return result;
	
	}
	public List<RegisterUserPojo> fetchdeleteUser(){
		System.out.println("executing RegisterDaoImpl::fetchdeleteUser");
		logger.info("executing RegisterDaoImpl::fetchdeleteUser");
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		  SessionFactory sf=config.buildSessionFactory();
		  
		  Session session=sf.openSession();
		
		Query fetchUserQuery = session.createQuery("RegisterUserPojo");
		List<RegisterUserPojo>userData = fetchUserQuery.list();
		
		session.close();
		System.out.println("exit RegisterDaoImpl::fetchdeleteUser");
		logger.info("exit RegisterDaoImpl::fetchdeleteUser");
		return userData;
}
}
