package com.frankie.daoimpl;

public class Dog  implements IAnimal{
	
	public void getNoice(){
		System.out.println("bow bow"); // using hibernate
	}
	public void getLegs(){
	
		System.out.println("4 legs");
	}
	public void database() {
		System.out.println("Hibernate flow");
		
	}

}
