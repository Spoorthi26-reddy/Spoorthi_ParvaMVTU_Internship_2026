package com.arrays_problems;

import java.util.Scanner;

public class largest_ele {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size of the array");
		int n=sc.nextInt();
		
		int arr[]=new int[n];
		
		System.out.println("enter the numbers");
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int max=arr[0];
		for(int i=0;i<n;i++) {
		if(arr[i]>max) {
			max=arr[i];
		}
		}
		System.out.println("largest element is "+ max);
	}
}
