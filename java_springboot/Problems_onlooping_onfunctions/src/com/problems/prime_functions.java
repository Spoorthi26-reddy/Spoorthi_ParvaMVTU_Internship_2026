package com.problems;

import java.util.Scanner;

public class prime_functions {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter the number");
		int n=sc.nextInt();
		Prime(n);
	}
	public static void Prime(int n) {
		boolean flag=true;
		for(int i=2;i<=n/2;i++) {
			if(n%i==0) {
				flag=false;
			}
		}
		if(flag==true)
			System.out.println("prime");
		else
			System.out.println("not a prime");
	}
}
