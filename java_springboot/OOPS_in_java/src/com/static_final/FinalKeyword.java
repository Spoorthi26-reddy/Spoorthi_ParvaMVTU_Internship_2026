package com.static_final;
//FINAL  :  We cannot change its value(we cannot override)
//variables
//methods
//classes

class Person{
	public  void display() {
		System.out.println("parent class display");
	}
}

class Student extends Person{
	
	@Override
	public void display() {
		System.out.println("child class display");
	}
}


public class FinalKeyword {
	public static void main(String[] args) {
		
		int age;
		age=30;
		System.out.println("Age:" +age);
		age=40;
		System.out.println("Age:" +age);
		Student S1= new Student();
		
		
		
	}

}
