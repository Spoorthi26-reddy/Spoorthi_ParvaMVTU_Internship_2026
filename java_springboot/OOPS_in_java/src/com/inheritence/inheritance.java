package com.inheritence;

class Parent{
	int age=40;
	public void parent() {
		System.out.println("this is a parent class method");
	}
}
class Child extends Parent{
	public void Child() {
		System.out.println("this is a child method");
	}

}

public class inheritance {
	public static void main(String[] args) {
		Child c1=new Child();
		System.out.println("age: "+c1.age);
		c1.parent();
		c1.Child();
		
	}
}
