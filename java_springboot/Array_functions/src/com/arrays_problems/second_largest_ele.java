package com.arrays_problems;

import java.util.Scanner;

public class second_largest_ele {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size");
		int n=sc.nextInt();
		
		int arr[]=new int[n];
		System.out.println("enter the numbers");
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int max=arr[0];
		int secMax=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++) {
			if(arr[i]>max) {
				secMax=max;
				max=arr[i];
			}else if(arr[i]<max && arr[i]>secMax) {
				secMax=arr[i];
			}
			
		}
		System.out.println(secMax);
		
	}
}
