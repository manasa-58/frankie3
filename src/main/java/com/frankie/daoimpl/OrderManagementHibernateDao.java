package com.frankie.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.ui.Model;

import com.controller.pojo.user.ItemInfo;
import com.frankie.dao.interf.IOrderManagementDao;

public class OrderManagementHibernateDao implements IOrderManagementDao{

	public int deleteItem(int itemId) {
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("delete ItemInfo where itemId= :id ");
		query.setParameter("id", itemId);
		int result = query.executeUpdate();
		tx.commit();
        session.close();
        return result;
	}
	public List<ItemInfo> fetchdeleteItem(){
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();

		Session session = sf.openSession();
		
		Query fetchMenuQuery = session.createQuery("from ItemInfo ");
		List<ItemInfo> menuData = fetchMenuQuery.list();
		
		session.close();
		 
		return menuData;
	}
	public ItemInfo editView(int itemId){
		
		System.out.println("executing OrderManagementDaoImpl:: editView");
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		  SessionFactory sf=config.buildSessionFactory();
		  
		  Session session=sf.openSession();
		  Query fetchMenuQuery = session.createQuery("from ItemInfo where itemId = :itemId");
		    fetchMenuQuery.setParameter("itemId",itemId);
			ItemInfo  item= (ItemInfo) fetchMenuQuery.list().get(0);
			session.close();
			System.out.println("exit OrderManagementDaoImpl:: editView");
		return item;
	}
	
	public void updateItem(ItemInfo item){
		System.out.println("executing OrderManagementDaoImpl :: updateItem");
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		  SessionFactory sf=config.buildSessionFactory();
		  
		  Session session=sf.openSession();
		  Transaction tx= session.beginTransaction();
		  session.update(item);
		  tx.commit();
		  
		  Query fetchMenuQuery = session.createQuery("from ItemInfo");
		  System.out.println("exit OrderManagementDaoImpl:: updateItem");
		  session.close();
		 
	}
	
}
