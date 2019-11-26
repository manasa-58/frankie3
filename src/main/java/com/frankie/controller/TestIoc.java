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
	}

}
