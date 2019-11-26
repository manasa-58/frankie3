package com.frankie.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.controller.pojo.user.ItemInfo;
import com.controller.pojo.user.RegisterUserPojo;
import com.frankie.services.RegisterServices;
import com.frankie.validation.FrankieValidation;

@Controller
public class RegisterController {
	
	@Autowired
	RegisterServices rs;
	@RequestMapping(value="/Registerform", method=RequestMethod.POST)
	public String register(RegisterUserPojo rup,Model m){
		System.out.println("executing RegisterController::register");
		
		String res=rs.register(rup,m);
		
		System.out.println(rup.getName()+"--"+rup.getMailid()+"  "+rup.getMobile()+" "+rup.getPassword()+" "+rup.getCity());
		System.out.println("The given registerform detail executed successfully");
		System.out.println("The given stmt is executed successfully");
		return res;
	}
	@RequestMapping(value="/loginUser",method=RequestMethod.POST)
	public String loginUser(@RequestParam("mailid") String mailid,@RequestParam("pwd") String pwd, Model m,HttpSession httpSession){
		
		System.out.println("executing UserController :: loginUser method ");
		String res=rs.loginUser(mailid, pwd, m, httpSession);
		System.out.println("exit UserController :: loginUser method ");
		
		return res;		
		
	}
	@RequestMapping(value="/usersPage")
	public String showMenu(Model model){
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		  SessionFactory sf=config.buildSessionFactory();
		  
		  Session session=sf.openSession();
		
		Query query = session.createQuery("from RegisterUserPojo");
		List<RegisterUserPojo>userData = query.list();
		
		for(RegisterUserPojo registerUser : userData){
			System.out.println(registerUser.getMailid()+"  "+registerUser.getName()+" "+registerUser.getMobile()+"  "+registerUser.getPassword()+registerUser.getCity());
			}
		model.addAttribute("userData",userData);
		return "user";

}
	@RequestMapping(value="/deleteUser",method=RequestMethod.POST)
	public String deleteUser(@RequestParam("mailid") String mailid, Model model){
		System.out.println("Delete request came for :" +mailid);
		System.out.println("executing UserController :: deleteUser ");
		String res=rs.deleteUser(mailid,model);
		System.out.println("exit UserController :: deleteUser ");
		
		return res;
	}
	@RequestMapping(value="/logout")
	public String logoutUser(Model model,HttpSession httpSession){
		model.addAttribute("message", "logout successfully completed!!");
		httpSession.removeAttribute("mailid");
		return "login";
	}
}
