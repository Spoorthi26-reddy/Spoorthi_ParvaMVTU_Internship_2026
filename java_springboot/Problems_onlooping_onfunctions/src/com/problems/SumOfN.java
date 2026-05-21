package com.problems;

import java.util.Scanner;

public class SumOfN {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		
//		int i=1;
//		int res=0;
//		while(i<=n) {
//			res=res+i;
//			i++;
//		}
//		System.out.println(res);
		
//		int res=0;
//		for(int i=1;i<=n;i++) {
//			res=res+1;
//		}
//		System.out.println(res);
	int sum=0;
	while(n>0) {
		int digit=n%10;
		sum=sum+digit;
		n=n/10;
	}
	System.out.println(sum);
	}
	
}
