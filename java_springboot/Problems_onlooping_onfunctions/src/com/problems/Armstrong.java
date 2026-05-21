package com.problems;

import java.util.Scanner;

public class Armstrong {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		
		int sum=0;
		int temp=n;
		
		while(temp>0) {
			int d = temp%10;
			sum=sum+d*d*d;
			temp=temp/10;
			
		}

        if(sum == n) {
            System.out.println("Armstrong Number");
        } else {
            System.out.println("Not an Armstrong Number");
        }
		
	}
}
