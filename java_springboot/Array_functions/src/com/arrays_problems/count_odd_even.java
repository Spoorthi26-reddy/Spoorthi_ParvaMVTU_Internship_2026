package com.arrays_problems;

import java.util.Scanner;

public class count_odd_even {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size");
		int n=sc.nextInt();
		
		int odd=0;
		int even=0;
		
		System.out.println("enter the numbers");
		for(int i=0;i<n;i++) {
			int num=sc.nextInt();
			
			if(num%2==0) {
				even++;
			}else {
				odd++;
			}
		}
		System.out.println("total even count is: "+even);
		System.out.println("total odd count is: "+odd);
	}
}
