package com.problems;

import java.util.Scanner;

public class SumOfOdd {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		int i = 1;
		int res=0;
		while(i<=n) {
			if(i%2!=0) 
				res=res+i;
				i++;
		}
			System.out.println(res);
	}
}
