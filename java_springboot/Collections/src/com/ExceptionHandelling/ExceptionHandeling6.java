package com.ExceptionHandelling;

import java.util.Scanner;

public class ExceptionHandeling6 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number:");
		int num1=sc.nextInt();
		int num2=sc.nextInt();
		try {
			String str=null;
			System.out.println("Result:" +str.toString());
			int res= num1/num2;
			System.out.println("Result:" +res);
		}catch(ArithmeticException e) {
			System.out.println("Exception: "+e.getMessage());
			
		}
		catch(Exception e) {
			System.out.println("Exception:" +e.getMessage());
		}finally {
			sc.close();
		}
	}

}
