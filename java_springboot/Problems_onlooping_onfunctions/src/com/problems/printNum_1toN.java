package com.problems;

import java.util.Scanner;

public class printNum_1toN {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter the number");
		int n=sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			System.out.println(i);
		}
	}
}
