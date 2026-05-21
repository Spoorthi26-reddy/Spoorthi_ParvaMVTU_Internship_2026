package com.functionalInterface;
//@FunctionalInterface
interface MyInterface{
	void display();
}

public class FunctionalInterface1 {
	public static void main(String[] args) {
		MyInterface i = ()->{System.out.println("hello world");
	};
	i.display();
}
}
