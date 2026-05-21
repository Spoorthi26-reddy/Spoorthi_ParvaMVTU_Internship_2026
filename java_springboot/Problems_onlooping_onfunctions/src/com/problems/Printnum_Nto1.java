package com.problems;

import java.util.Scanner;

public class Printnum_Nto1 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter the number");
		int n=sc.nextInt();
		
		for(int i=n;i>=1;i--) {
			System.out.println(i);
		}
	}
}
