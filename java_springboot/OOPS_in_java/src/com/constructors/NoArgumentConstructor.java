package com.constructors;

class Employee{
	String name;
	int age;
	Employee(){
		System.out.println("emp constructor");
	}
}

public class NoArgumentConstructor {
	public static void main(String[] args) {
		Employee emp1=new Employee();
		emp1.name="ram";
		emp1.age=23;
		System.out.println("Name:"+emp1.name);
		System.out.println("Age:"+emp1.age);
	}
}
