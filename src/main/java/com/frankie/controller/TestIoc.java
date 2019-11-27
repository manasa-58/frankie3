package com.frankie.controller;

import com.controller.pojo.user.Passport;
import com.controller.pojo.user.Student;

public class TestIoc {
	public static void main(String[] args) {
		Student s1=new Student();
		s1.setStdId(166);
		s1.setName("raashi");
		s1.setClg("KITS");
		s1.setCity("KNR");
		s1.setPport(new Passport());
		
		Student s2=new Student(166,"raashi","KITS","KNR",new Passport());
		
		 Student s3=new Student();
		   s3.setStdId(123);
		   s3.setName("Jaya");
		   s3.setClg("NGMA");
		   s3.setCity("Warangal");
		   s3.setPport(new Passport());
		   System.out.println(s3.getName()+"  "+s3.getClg());
		   
		   Student s4= new Student();
		   s4.setStdId(123);
		   s4.setName("ravali");
		   s4.setClg("cmr");
		   s4.setCity("nzd");
		   s4.setPport(new Passport());
		   System.out.println("student 4 details entered");
		   
	}
  
}
