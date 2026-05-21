package com.static_final;

class Car{
	java.lang.String name;
	static int noWheels=4;
	
	public static void display() {
		System.out.println("no. of wheels: "+Car.noWheels);
	}
}

public class StaticKeyword {
	
	
	public static void main(String[] args) {
		
	
		System.out.println("detals");
		Car c=new Car();
		c.name="Tesla";
		Car.display();
		Car c1=new Car();
		c1.name="BMW";
		Car.display();
		
	}

}
