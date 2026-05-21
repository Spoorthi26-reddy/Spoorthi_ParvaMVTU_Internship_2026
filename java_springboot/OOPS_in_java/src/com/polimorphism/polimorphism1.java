package com.polimorphism;

class Addition {
	public void add(int a,int b) {
		System.out.println("result: "+(a+b));
	}
	public void add(int a,int b,int c) {
		System.out.println("result: "+(a+b+c));
	}
	public void add(float a,int b,int c) {
		System.out.println("result: "+(a+b+c));
	}
	
}

public class polimorphism1 {
	public static void main(String[] args) {
		Addition add1 = new Addition();
		add1.add(20,50);
		add1.add(20,50,70);
		add1.add(20f,50,70);
		
	}

}
