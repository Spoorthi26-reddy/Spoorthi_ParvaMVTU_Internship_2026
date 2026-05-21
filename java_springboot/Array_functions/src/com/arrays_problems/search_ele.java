package com.arrays_problems;

import java.util.Scanner;

public class search_ele {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size");
		int n=sc.nextInt();
		
		int[] arr=new int[n];
		
		System.out.println("enter the numbers");
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println("enter the element you hv to found");
		int x= sc.nextInt();
		
		for(int i=0;i<n;i++) {
		if(arr[i]==x) 
			System.out.println("element found at index: "+i);
		
		}
	}
}

