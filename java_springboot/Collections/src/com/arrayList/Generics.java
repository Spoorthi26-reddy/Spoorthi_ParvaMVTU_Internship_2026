package com.arrayList;
class MyGenericsClass<T>{
	private T variable;
	
	public MyGenericsClass(T variable) {
		this.variable = variable;
	}
	
	public T getVariable() {
		return variable;
	}
	
	public void setVariable(T variable) {
		this.variable = variable;
		
	}
}


public class Generics {
	public static void main(String[] args) {
		MyGenericsClass<Integer> Obj1 = new MyGenericsClass<>(21);
		System.out.println("value:" +Obj1.getVariable());
		
		MyGenericsClass<String> Obj2 = new MyGenericsClass<>("Hello");
		System.out.println("value:" +Obj2.getVariable());
		
	}
}
