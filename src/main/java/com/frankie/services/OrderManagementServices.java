package com.frankie.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.controller.pojo.user.ItemInfo;
import com.frankie.dao.interf.IOrderManagementDao;
import com.frankie.dao.jdbc.impl.OrderManagementJdbcDaoImpl;
import com.frankie.daoimpl.OrderManagementHibernateDao;
import com.frankie.daoimpl.OrderManagementHibernateDao;

public class OrderManagementServices {
	
	@Autowired
	IOrderManagementDao omd ;//= new OrderManagementJdbcDaoImpl();
	public String deleteItem(int itemId, Model model) {
		
		int result = omd.deleteItem(itemId);
		if (result == 1) {
			System.out.println("Deleted successfully!!");
			String message = itemId + "deleted successfully";
			model.addAttribute("msg", message);
		} else {
			System.err.println("Failed to delete!!");
			String message = itemId + "Failed to delete";
			model.addAttribute("msg", message);
		}
		List<ItemInfo> menuData = omd.fetchdeleteItem();
		model.addAttribute("menuData", menuData);
		return "menu";
	}
	
	public String editView(int itemId, Model model){
		System.out.println("executing OrderManagementServices::editView");
		
		ItemInfo  item=omd.editView(itemId);
		
			model.addAttribute("itemInfo", item);
			if(item.getTypeOfItem().equals("Veg")){
				model.addAttribute("veg","checked");
			} else
				model.addAttribute("nonVeg","checked");
			System.out.println("exit OrderManagementServices::editView");
		
	return "editView";	
	}
	
	public String updateItem(ItemInfo item, Model model){
		System.out.println("executing OrderManagementServices::updateItem");
		omd.updateItem(item);
			List<ItemInfo> menuData = omd.fetchdeleteItem();
			model.addAttribute("menuData",menuData);
			System.out.println("exit OrderManagementServices::updateItem");
	return "menu";	
	}
	
}
