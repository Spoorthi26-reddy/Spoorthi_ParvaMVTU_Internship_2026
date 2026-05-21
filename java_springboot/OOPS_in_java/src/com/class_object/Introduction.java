package com.class_object;

class Car{
	//properties
	String name="BMW";
	long price = 20000000;
	
	//behavior
	public void canDrive() {
		System.out.println("yes");
	}
}

public class Introduction {
	public static void main(String[] args) {
		
		
		
		/*
		 * OOPS: Java is not completely oops cuz we use primitive data types
		 * 
		 * 1.CLASS : it will represent the state and behavior of an object
		 *           state---represent the properties of an object(variables)
		 *           behavior----represent the action of an object(functions/methods)
		 *           
		 *   Syntax:
		 *   
		 *   access_modifier class_name{
		 *     //properties
		 *     
		 *     //behavior
		 *     }
		 *     
		 * 2.OBJECT : it is the implementation of class
		 *    -class will not take a memory ,where as object will.
		 *    -to create object in java we use "new"		 *     
		 * 
		 *   Syntax:
		 *   
		 *   new class_name();
		 *   
		 *   class_name obj_name = new class_name();
		 */
		
		Car c= new Car();
		System.out.println("name:" +c.name);
		System.out.println("price:" +c.price);
		c.canDrive();
		
	}
}
