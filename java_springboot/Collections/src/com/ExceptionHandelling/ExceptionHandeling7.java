package com.ExceptionHandelling;

public class ExceptionHandeling7 {
	public static void main(String[] args) {
		int age =10;
		try {
			validate(age);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("program completed");
		}
	}

	private static void validate(int age) {
		// TODO Auto-generated method stub
		if(age>=18) {
			System.out.println("your age is valid");
		}else {
			throw new ArithmeticException("Invalid age number");
		}
		
	}

}
