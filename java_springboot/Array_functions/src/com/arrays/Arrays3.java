package com.arrays;

import java.util.Scanner;

public class Arrays3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size");
		int size = sc.nextInt();
		int arr[]=new int[size];
		
		int i=0;
		while(i<=size-1) {
			System.out.println("enter "+ i + " values");
			arr[i]=sc.nextInt();
			i++;
		}
		 int res=0;
		 for(int j=0;j<=size-1;j++) {
			 res=res+arr[j];
		 }
		 System.out.println("Result: "+res);
	}
}
