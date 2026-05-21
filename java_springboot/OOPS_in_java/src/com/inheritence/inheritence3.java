package com.inheritence;

class Vehicle{
	public String brand;
	public String model;
	public Vehicle(String brand, String model) {
		super();
		this.brand =brand;
		this.model=model;
	}
}

class Car extends Vehicle{
	public int noWheels;
	
	public Car(String brand, String model,int noWheels) {
		super(brand,model);
		this.noWheels=noWheels;
	}
	@Override
	public String toString() {
		return "Car [noWheels="+noWheels +", brand=" +brand + ",model="+model+"]";
		
	}
}

public class inheritence3 {
	public static void main(String[] args) {
		Car c=new Car("Tesla","Modelx",4);
		System.out.println(c);
	}

}
