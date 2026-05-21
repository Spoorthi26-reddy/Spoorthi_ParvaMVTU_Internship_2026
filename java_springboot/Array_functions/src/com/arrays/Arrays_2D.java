package com.arrays;

import java.util.Scanner;

public class Arrays_2D {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the elements");
		int arr[][]=new int[2][3];
		
		for(int i=0;i<=1;i++) {
			for(int j=0;j<=2;j++) {
				System.out.println("enter ["+i+"]["+j+"] ele:" );
				arr[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<=1;i++) {
			for(int j=0;j<=2;j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		
		}
		
	}
}
