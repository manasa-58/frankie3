package com.frankie.daoimpl;

public class Cat implements IAnimal{
	
	public void getNoice(){
		System.out.println("meow meow");  // using jdbc 
	}
	public void getLegs(){
	
		System.out.println("4 legs");
	}
	public void database() {
		System.out.println("Jdbc flow"); 
		
	}


}
