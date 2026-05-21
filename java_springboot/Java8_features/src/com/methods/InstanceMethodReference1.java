package com.methods;

import java.util.function.Supplier;

public class InstanceMethodReference1 {
	public String getMessage() {
		return "Instance Method";
	}
	public static void main(String[] args) {
		InstanceMethodReference1 obj1= new InstanceMethodReference1();
		//without
		Supplier<String> sup = () -> obj1.getMessage();
		System.out.println("res:" +sup.get());
		//with
		Supplier<String> sup2 =obj1::getMessage;
		System.out.println("res2:" +sup2.get());
		
	}
}
