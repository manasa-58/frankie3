package com.controller.pojo.user;

import java.util.List;

public class Student {
	private int stdId;
	private String name;
	private String clg;
	private String city;
	private List<String> subjects;
	private Passport pport;
	
	public Student(){
		System.out.println("no argument constructor of student");
	}
	public Student(String clgName,String city,Passport pport){
		System.out.println("3 arg student constructor");
		this.clg=clgName;
		this.city=city;
		this.pport=pport;
	}
	
	public Student(int stdId, String name, String clg, String city, Passport pport) {
		System.out.println("no argument constructor of student");
		
		this.stdId = stdId;
		this.name = name;
		this.clg = clg;
		this.city = city;
		this.pport = pport;
	}
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClg() {
		return clg;
	}
	public void setClg(String clg) {
		this.clg = clg;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	public Passport getPport() {
		return pport;
	}
	public void setPport(Passport pport) {
		this.pport = pport;
	}

}
