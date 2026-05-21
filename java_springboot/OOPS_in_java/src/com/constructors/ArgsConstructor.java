package com.constructors;

class Person1{
	String name;
	int age;
	String email;
	
	Person1(){
		System.out.println("Person1 constructor");
	}
	
	Person1(String name,int age,String email){
		System.out.println("person1 args constructor");
		this.name=name;
		this.age=age;
		this.email=email;
	}
	
	public void display() {
		System.out.println("Name: "+this.name);
		System.out.println("Name: "+this.age);
		System.out.println("Name: "+this.email);
	}
}

public class ArgsConstructor {
	public static void main(String[] args) {
		Person1 p1=new Person1();
		p1.display();
		Person1 p2 = new Person1("swan",22,"parvam@gmail.com");
		p1.display();
		Person1 p3 = new Person1("swar",26,"");
		p1.display();
		Person1 p4 = new Person1("swan123",45,"");
		p1.display();
		
	}
}
