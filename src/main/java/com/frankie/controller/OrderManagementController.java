package com.frankie.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.controller.pojo.user.ItemInfo;
import com.frankie.daoimpl.OrderManagementHibernateDao;
import com.frankie.services.OrderManagementServices;

@Controller
public class OrderManagementController {
	
	@Autowired
	OrderManagementServices oms;//=new OrderManagementServices();
	
	@RequestMapping(value="/addItemPage" )
	public String showAddItemPage(Model model/*,HttpSession httpSession*/){
		
		/*String mailid=(String) httpSession.getAttribute("mailid");
		System.out.println("show addItemPage for:"  +mailid);
		if(mailid==null || mailid.isEmpty()){
			model.addAttribute("message","please login first to access menu page !!");
			return "login";
		}*/
		
		System.out.println("executing OrderManagementController :: showAddItem method");
		return "addItemtomenu";
	}

	@RequestMapping(value="/addItemToMenu",method=RequestMethod.POST)
	public String addItemToMenu(ItemInfo item, Model model/*,HttpSession httpSession*/){
		
		/*String mailid=(String) httpSession.getAttribute("mailid");
		System.out.println("showMenu for:"  +mailid);
		if(mailid==null || mailid.isEmpty()){
			model.addAttribute("message","please login first to access menu page !!");
			return "login";
		}*/
		
		System.out.println(item.getItem()+" "+item.getPrice()+" "+item.getQty()+" "+item.getTypeOfItem());
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		  SessionFactory sf=config.buildSessionFactory();
		  
		  Session session=sf.openSession();
		  Transaction tx= session.beginTransaction();
		  session.save(item);
		  String msg=item.getItem()+" added to menu successfully!!";
		  model.addAttribute("message", msg);
		  tx.commit();
		  session.close();
		return "addItemtomenu";
	}
	
	@RequestMapping(value="/showMenu")
	public String showMenu(Model model/*,HttpSession httpSession*/){
		
		/*String mailid=(String) httpSession.getAttribute("mailid");
		System.out.println("showMenu for:"  +mailid);
		if(mailid==null || mailid.isEmpty()){
			model.addAttribute("message","please login first to access menu page !!");
			return "login";
		}*/
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		  SessionFactory sf=config.buildSessionFactory();
		  
		  Session session=sf.openSession();
		
		Query query = session.createQuery("from ItemInfo ");
		List<ItemInfo> menuData = query.list();
		
		for(ItemInfo iteminfo : menuData){
			System.out.println(iteminfo.getItemid()+" "+iteminfo.getItem()+"  "+iteminfo.getPrice()+" "+iteminfo.getQty()+" "+iteminfo.getTypeOfItem());
		}
		model.addAttribute("menuData",menuData);
		return "menu";
	}
	
	@RequestMapping(value="/deleteItem",method=RequestMethod.POST)
	public String deleteItem(@RequestParam("itemId") int itemId, Model model){
		System.out.println("Delete request came for :" +itemId);
		
		
		String result=oms.deleteItem(itemId, model);
		
		return result;
	}
		
	@RequestMapping(value="/editItemView", method=RequestMethod.POST)
	public String editView(@RequestParam("itemId") int itemId, Model model){
		System.out.println("executing OrderManagementController::editView");
		String result=oms.editView(itemId, model);
		System.out.println("exit OrderManagementController::editView");
		return result;
		
	}
	
	@RequestMapping(value="/updateItem",method=RequestMethod.POST)
	public String updateItem(ItemInfo item, Model model){
		System.out.println("executing OrderManagementController::updateItem");
		String result=oms.updateItem(item, model);
		System.out.println("exit OrderManagementController::updateItem");
		return result;
	}
	
	
	
	
	
	
	
}
