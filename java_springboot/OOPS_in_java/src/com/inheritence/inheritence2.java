package com.inheritence;

class GrandParent{
	int age=80;
	public void grandParent() {
		System.out.println("GrandParent class method");
	}
}

class Parent1 extends GrandParent{
	
}

class Child1 extends Parent1{
	
}

public class inheritence2 {
	public static void main(String[] args) {
		Child1 c1=new Child1();
		System.out.println(c1.age);
		c1.grandParent();
	}

}
