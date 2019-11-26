package com.frankie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controller.pojo.user.College;
import com.controller.pojo.user.Passport;
import com.controller.pojo.user.Student;
import com.frankie.daoimpl.Cat;
import com.frankie.daoimpl.Dog;
import com.frankie.daoimpl.Human;
import com.frankie.daoimpl.IAnimal;
@Controller
public class TestController {
	@Autowired(required=false)
	private Student s1;
	
	
	@Autowired(required=false)
	private Student s2;
	
	@Qualifier(value="kitObj")
	@Autowired
	College c1;
	@Qualifier(value="kitObj")
	@Autowired
	College c2;
	@Qualifier(value="cbiObj")
	@Autowired
	College c3;
	@Qualifier(value="cbiObj")
	@Autowired
	College c4;
	
	@RequestMapping(value="/testIoc")
	public String testIoc(){
		System.out.println("Triggered testIoc method");
		if(s1==null){
			System.out.println("s1 is null");
			s1= new Student();
			s1.setPport(new Passport());
		}
		if (s2==null){
			System.out.println("s2 is null");
			s2=new Student();
			s2.setPport(new Passport());
		}
		
		System.out.println("----college----");
		c1.setLocation("karimnagar");
		c2.setLocation("karimnagar");
		c3.setLocation("hyderabad");
		c3.setLocation("hyderabad");
		
		System.out.println(c1.getCollegeName()+"  "+c1.getLocation());
		System.out.println(c2.getCollegeName()+"  "+c2.getLocation());
		System.out.println(c3.getCollegeName()+"  "+c3.getLocation());
		System.out.println(c4.getCollegeName()+"  "+c4.getLocation());
		
		System.out.println("----college----");
		
		s1.setStdId(101);
		s1.setName("sweety");
		s1.getPport().setPptId(4567945);
		s1.getPport().setIssuedLocation("mumbai");
		s1.getPport().setExpiryDate("2024");
		
		/*s1.setClg("VITS");
		s1.setCity("KNR");*/
		
		s2.setStdId(102);
		s2.setName("usha");
		s2.getPport().setPptId(98712332);
		s2.getPport().setIssuedLocation("chennai");
		s2.getPport().setExpiryDate("2023");
		
		/*s2.setClg("VITS");
		s2.setCity("KNR");*/
		
		/*List<String>list=s1.getSubjects();
		for (String st : list) {
			System.out.println(st);*/
		
		/*System.out.println("1.8 example");
		list.forEach(System.out::println);
		System.out.println("---------");*/
		
		System.out.println(s1.getName()+" "+s1.getName()+"  "+s1.getClg()+"  "+s1.getCity()+"  "+s1.getPport().getPptId()+"  "+s1.getPport().getIssuedLocation()+"  "+s1.getPport().getExpiryDate());
		System.out.println(s2.getName()+" "+s2.getName()+"  "+s2.getClg()+"  "+s2.getCity()+"  "+s2.getPport().getPptId()+"  "+s2.getPport().getIssuedLocation()+"  "+s2.getPport().getExpiryDate());
		return "frankie";
	}
	public static void main(String[] args) {
		IAnimal animal=new Dog();
		animal.getNoice();
		animal.getLegs();
		animal.database();
	}

}
