package com.arrays_problems;

import java.util.Scanner;

public class second_smallest_ele {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size");
		int n=sc.nextInt();
		
		int arr[]=new int[n];
		System.out.println("enter the numbers");
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int min=arr[0];
		int secMin=Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++) {
			if(arr[i]<min) {
				secMin=min;
				min=arr[i];
			}else if(arr[i]>min && arr[i]<secMin) {
				secMin=arr[i];
			}
			
		}
		System.out.println(secMin);
	}
}
