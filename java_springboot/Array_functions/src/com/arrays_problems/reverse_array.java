package com.arrays_problems;

import java.util.Scanner;

public class reverse_array {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size");
		int n=sc.nextInt();
		
		int arr[]=new int[n];
		System.out.println("enter the elements");
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();	
		}
		 for(int i = 0; i < n / 2; i++) {
	            int temp = arr[i];
	            arr[i] = arr[n - 1 - i];
	            arr[n - 1 - i] = temp;
	        }

	        System.out.println("Reversed array:");
	        for(int i = 0; i < n; i++) {
	            System.out.print(arr[i] + " ");
	        }
	}
}
