package com.frankie.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.controller.pojo.user.RegisterUserPojo;
import com.frankie.dao.interf.IRegisterDao;
import com.frankie.dao.jdbc.impl.RegisterJdbcDaoImpl;
import com.frankie.daoimpl.RegisterHibernateDaoImpl;
import com.frankie.daoimpl.RegisterHibernateDaoImpl;
import com.frankie.validation.FrankieValidation;

public class RegisterServices {
	
	@Autowired
	IRegisterDao rdi;
	//RegisterHibernateDaoImpl rdi=new RegisterHibernateDaoImpl();
	 // RegisterJdbcDaoImpl rdi=new RegisterJdbcDaoImpl();
	public String register(RegisterUserPojo rup,Model m){
		
		
		rdi.register(rup);
		
		//validation  logic here
				boolean isValidMail= FrankieValidation.isValidMail(rup.getMailid());
				System.out.println("Mail validation check:" +isValidMail);
				if(!isValidMail){
					m.addAttribute("message", "Invalid mailid entered!! please try with valid one");
					return "frankie";
				}
				boolean isValidMobile= FrankieValidation.isValidMobile(rup.getMobile());
				System.out.println("Mail validation check:" +isValidMobile);
				if(!isValidMobile){
					m.addAttribute("message", "Invalid Mobile entered!! please try with valid one");
					return "frankie";
				}
					
				//validation logic end here
				
		return "login";
	}
	
	public String loginUser(String mailid,String pwd, Model m, HttpSession httpSession){
		
		System.out.println("executing loginUserservice ::loginUser");
		List<RegisterUserPojo> list=rdi.loginUser(mailid, pwd);
		  if(list==null||list.isEmpty()){
			m.addAttribute("message","Invalid mailid or password entered !!please try again !!") ;
			return "login";
		  }
		  System.out.println("login for" +mailid);
		  httpSession.setAttribute("mailid",mailid);
		  httpSession.setMaxInactiveInterval(20);
		  for (RegisterUserPojo rup:list){
			  System.out.println(rup.getName()+"  "+rup.getMailid()+"  "+rup.getMobile()+"  "+rup.getPassword()+"  "+rup.getCity());
		  }
		  System.out.println("parsing is done!!");
		  System.out.println("exit loginUserservice ::loginUser");
		return "profile";

	}
	
	public String deleteUser(String mailid, Model model){
		System.out.println("executing RegisterServices::deleteUser");
		int result=rdi.deleteUser(mailid);
		 if(result==1){
			  System.out.println("Deleted successfully!!");
			  String message=mailid + "deleted successfully";
			  model.addAttribute("msg" ,message);
		  }else{
			  System.out.println("Failed to delete!!");
			  String message=mailid + "Failed to delete";
			  model.addAttribute("msg" ,message);
		  }
		  
		 List<RegisterUserPojo>userData =rdi.fetchdeleteUser();
			model.addAttribute("userData",userData);
			System.out.println("exit RegisterServices::deleteUser");
		return "userData";
	
}
}
