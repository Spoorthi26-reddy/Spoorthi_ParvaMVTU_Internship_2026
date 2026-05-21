package Function_in_java;

import java.util.Scanner;

public class functions3 {
	private static int a;
	private static int b;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two numbers:");
		int a= sc.nextInt();
		int b = sc.nextInt();
		
		int res = add(a,b);
		System.out.println("addition:"+res);
		
		sub(a, b);
		
		int res2=mul();
		System.out.println("multiplication: "+ res2);
		
		div();
		 
			
	}
	public static int add(int a, int b) {
		return a+b;
	}
	
	public static void sub (int a, int b) {
		System.out.println("subtraction:" +(a-b));
	}
	
	public static int mul() {
		int a=5;
		int b=6;
		return a*b;
	}
	
	public static void div() {	
		int a=10;
		int b=2;
		System.out.println(a/b);
	}

}
