package com.problems;

import java.util.Scanner;

public class productOfDigits {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		int i=1;
		int product=1;
		while(n>0) {
			int digit=n%10;
			product=product*digit;
			n=n/10;
		}
		System.out.println(product);
	}
}
