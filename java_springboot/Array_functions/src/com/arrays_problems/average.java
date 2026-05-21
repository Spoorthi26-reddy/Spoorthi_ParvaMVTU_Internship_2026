package com.arrays_problems;

import java.util.Scanner;

public class average {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size");
		int n=sc.nextInt();
		
		int arr[]=new int[n];
		System.out.println("enter the elements");
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int sum=0;
		int avg=0;
		for(int j=0;j<n;j++) {
			sum=sum+arr[j];
			avg=sum/arr.length;
		}
		System.out.println("Sum is: "+sum);
		System.out.println("Average is: "+avg);
	}
}
